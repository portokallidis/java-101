package unistudent;

import java.util.List;
import java.util.ArrayList;

public class UniStudent {
    
    private final int ID_INIT = 1000;

    private List<Course> Courses;
    private int CourseNextID;
    private List<Student> Students;
    private int StudentNextID;
    private List<Lecturer> Lecturers;
    private int LecturerNextID;
    private List<LecturerCourse> LecturerCourses;
    private List<StudentCourse> StudentCourses;
    

    public UniStudent() {
        /** 
         * Load Initial Data (either from Files or empty Lists)
         */
        this.Courses = UnistudentData.loadCourses();
        this.CourseNextID = this.getCourseMaxId(this.Courses)+1;
        this.Students = UnistudentData.loadStudents();
        this.StudentNextID = this.getStudentMaxId(this.Students)+1;
        this.Lecturers = UnistudentData.loadLecturers();
        this.LecturerNextID = this.getLecturerMaxId(this.Lecturers)+1;
        this.LecturerCourses = UnistudentData.loadLecturerCourses();
        this.StudentCourses = UnistudentData.loadStudentCourses();
       
        
    }

    
    public boolean saveData() {        
        try {
            UnistudentData.saveCourses(this.Courses);
            UnistudentData.saveStudents(this.Students);
            UnistudentData.saveLecturers(this.Lecturers);
            UnistudentData.saveLecturerCourses(this.LecturerCourses);
            UnistudentData.saveStudentCourses(this.StudentCourses);
        } catch (Exception e) {
            ErrorHandler.text("Error while saving data.");
            return false;
        }

        return true;
    }


    /**
     * STUDENT METHODS
     * 
     */
    
    public String listStudents() {
        String list="---Students---\n";
        for (int i = 0; i < this.Students.size(); i++) { 
            list+=this.Students.get(i).show()+"\n";
        }
        return list;
    }    
    
    /**
    * Create a new student
    * @param name
    * @param phone
    * @param email
    * @param semester
    * @return Student
    */
    public Student addStudent(String name, String phone, String email, String semester) {
        Student student = new Student(this.StudentNextID, name, phone, email, semester);
        this.Students.add(student);
        this.StudentNextID++;
        return student;
    }
    
    /**
    * Create a new student
    * @param name
    * @param phone
    * @param email
    * @param semester
    * @return Student
    */
    public Student getStudent(int id) {
        Student result = null;
        for (int i = 0; i < this.Students.size(); i++) { 
            if(this.Students.get(i).getId()==id) {
                result = this.Students.get(i);
                break;
            }
        }
        return result;
    }
    
    /**
    * Delete a student
    * @param id
    */
    public void remvoveStudent(int id) {
        Student result = this.getStudent(id);
        if(result.getId()>0) this.Students.remove(result);
    }
    
    /**
    * Set student's grade for a Course
    * @param studentId
    * @param courseId
    * @param grade
    */
    public void setStudentGradeForCourse(int studentId, int courseId,int grade){
        StudentCourse sc = this.getStudentCourse(studentId, courseId);
        if(sc!=null) {
            sc.setGrade(grade);
        }
    }
    
    /**
    * Assign a course to a student
    * @param studentId
    * @param courseId
    */
    public void assignCourseToStudent(int studentId, int courseId){
        StudentCourse sc;
        try {
            sc = this.getStudentCourse(studentId, courseId);
        } catch(Exception e) {
            sc = new StudentCourse(studentId, courseId);
            this.StudentCourses.add(sc);
        }
    }
    
    /**
    * Retrieve a student-course relation
    * @param studentId
    * @param courseId
    */
    public StudentCourse getStudentCourse(int studentId, int courseId){
        StudentCourse result = null;
        for (int i = 0; i < this.StudentCourses.size(); i++) { 
            result = this.StudentCourses.get(i);
            if(result.getStudentId()==studentId && result.getCourseId()==courseId) {
                break;
            } else result = null;
        }
        System.out.println(result.getCourseId());
        return result;
    }


    /**
     * LECTURER METHODS
     * 
     *  */ 

    public String listLecturers() {
        String list="---Lecturers---\n";
        for (int i = 0; i < this.Lecturers.size(); i++) { 
            list+=this.Lecturers.get(i).show()+"\n";
        }
        return list;
    }    
    
    /**
    * Create a new lecturer
    * @param name
    * @param phone
    * @param email
    * @param scientificField
    * @return Lecturer
    */
    public Lecturer addLecturer(String name, String phone, String email, String scientificField) {
        Lecturer lecturer = new Lecturer(this.LecturerNextID, name, phone, email, scientificField);
        this.Lecturers.add(lecturer);
        this.LecturerNextID++;
        return lecturer;
    }
    
    /**
    * Retrieve a lecturer
    * @param id
    * @return Lecturer
    */
    public Lecturer getLecturer(int id) {
        Lecturer result = null;
        for (int i = 0; i < this.Lecturers.size(); i++) { 
            result = this.Lecturers.get(i);
            if(result.getId()==id) {
                break;
            } else result = null;
        }
        return result;
    }    
    
    /**
    * Delete a lecturer
    * @param id
    */
    public void removeLecturer(int id) {
        Lecturer result = this.getLecturer(id);
        if(result.getId()>0) this.Lecturers.remove(result);
    }
    
    /**
    * Assign a course to a lecturer
    * @param lecturerId
    * @param courseId
    */
    public void assignCourseToLecturer(int lecturerId, int courseId){
        LecturerCourse lc = this.getLecturerCourse(lecturerId, courseId);
        if(lc==null) {
            lc = new LecturerCourse(lecturerId, courseId);
            this.LecturerCourses.add(lc);
        }
    }
    
    /**
    * Retrieve a lecturer-course relation
    * @param lecturerId
    * @param courseId
    */
    private LecturerCourse getLecturerCourse(int lecturerId, int courseId){
        LecturerCourse result = null;
        for (int i = 0; i < this.LecturerCourses.size(); i++) { 
            result = this.LecturerCourses.get(i);
            if(result.getLecturerId()==lecturerId && result.getCourseId()==courseId) {
                break;
            } else result = null;
        }
        return result;
    }

    /**
     * COURSE METHODS
     * 
     *  */ 
    
    public String listCourses() {
        String list="---Courses---\n";
        for (int i = 0; i < this.Courses.size(); i++) { 
            list+=this.Courses.get(i).show()+"\n";
        }
        return list;
    }    
    
    /**
    * Retrieve all assigned courses for a student
    * @param studentId
    */
    public String listStudentCourses(int studentId) {
        
        List<Integer> courseFilter = new ArrayList<Integer>();
        StudentCourse tmp = null;
        Course tmpCourse = null;
        
        for (int i = 0; i < this.StudentCourses.size(); i++) { 
            tmp = this.StudentCourses.get(i);
            if(tmp.getStudentId()==studentId) {
                if(courseFilter.indexOf(tmp.getCourseId())==-1) {
                    courseFilter.add(tmp.getCourseId());
                }
            }
        }
        
        if(courseFilter.size()==0) throw new RuntimeException();
        
        String list="---Courses---\n";
        for (int i = 0; i < this.Courses.size(); i++) { 
            tmpCourse = this.Courses.get(i);
            if(courseFilter.indexOf(tmpCourse.getId())>=0) {
                list+=tmpCourse.show()+"\n";
            }
        }
        return list;
    }    
    
    /**
    * Create a new course
    * @param title
    * @param semester
    * @return Course
    */
    public Course addCourse(String title, String semester) {
        Course course = new Course(this.CourseNextID, title, semester);
        this.Courses.add(course);
        this.CourseNextID++;
        return course;
    }
    
    /**
    * Retrieve a course
    * @param id
    * @return Course
    */
    public Course getCourse(int id) {
        Course result = null;
        for (int i = 0; i < this.Courses.size(); i++) { 
            result = this.Courses.get(i);
            if(result.getId()==id) {
                break;
            } else result = null;
        }
        return result;
    }    
    
    /**
    * Delete a course
    * @param id
    */
    public void removeCourse(int id) {
        Course result = this.getCourse(id);
        if(result.getId()>0) this.Courses.remove(result);

    }


    /**
     * STATISTICS METHODS
     * 
     */
    

    public void showStudentsWithMeanGrade(){
        Statistics.calculateMeanGradePerStudent(this.Students,this.StudentCourses,false);
    }
    public void showCoursesWithMeanGrade(){
        Statistics.calculateMeanGradePerCourse(this.Courses,this.StudentCourses,false);
    }

    public void showStudentGraphWithMeanGrade(){
        Statistics.calculateMeanGradePerStudent(this.Students,this.StudentCourses,true);
    }
    public void showCourseGraphWithMeanGrade(){
        Statistics.calculateMeanGradePerCourse(this.Courses,this.StudentCourses,true);
    }


    
    /**
     * 
     * Helper Methods
     * 
     */

    public int getStudentMaxId(List<Student> list){
        int max = Integer.MIN_VALUE;
        Student result;
        for (int i = 0; i < list.size(); i++) { 
            result = list.get(i);
            if(result.getId() > max) {
                max = result.getId();
            }
        }
        if(max<this.ID_INIT) return this.ID_INIT;
        else return max;
    }

    public int getLecturerMaxId(List<Lecturer> list){
        int max = Integer.MIN_VALUE;
        Lecturer result;
        for (int i = 0; i < list.size(); i++) { 
            result = list.get(i);
            if(result.getId() > max) {
                max = result.getId();
            }
        }
        if(max<this.ID_INIT) return this.ID_INIT;
        else return max;
    }

    public int getCourseMaxId(List<Course> list){
        int max = Integer.MIN_VALUE;
        Course result;
        for (int i = 0; i < list.size(); i++) { 
            result = list.get(i);
            if(result.getId() > max) {
                max = result.getId();
            }
        }
        if(max<this.ID_INIT) return this.ID_INIT;
        else return max;
    }

    private void handleError(String s) {
        System.out.println("Error: " + s);
    }

}