package unistudent;

import java.util.List;
import java.util.ArrayList;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;

public class UnistudentData {
    
    // Configuration
    static final String COURSES_FILE="_db_courses.dat";
    static final String STUDENTS_FILE="_db_students.dat";
    static final String LECTURERS_FILE="_db_lecturers.dat";
    static final String STUDENT_COURSE_FILE="_db_student_course.dat";
    static final String LECTURER_COURSE_FILE="_db_lecturer_course.dat";

    public UnistudentData() { }


    /**
     * 
     * @param List<Course>
     */
    static void saveCourses(List<Course> courses) {
        try {
            FileOutputStream fos = new FileOutputStream(COURSES_FILE);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(courses);
            oos.close();
        } catch(Exception e) {
            ErrorHandler.text("Error while saving courses.");
        }
    }
    
    /**
     * 
     * @return List<Course>
     */
    static List<Course> loadCourses() {
        List<Course> courses = new ArrayList<Course>();
        try {
            FileInputStream fis = new FileInputStream(COURSES_FILE);
            ObjectInputStream ois = new ObjectInputStream(fis);
            courses = (List<Course>) ois.readObject();
            ois.close();
        } catch (Exception e){
            // ErrorHandler.text("Error while loading courses.");
            return new ArrayList<Course>();
        }
        return courses;
    }

    
    static void saveStudents(List<Student> students) {
        try {
            FileOutputStream fos = new FileOutputStream(STUDENTS_FILE);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(students);
            oos.close();
        } catch(Exception e) {
            ErrorHandler.text("Error while saving students.");
        }
    }

    static List<Student> loadStudents() {
        List<Student> students = new ArrayList<Student>();
        try {
            FileInputStream fis = new FileInputStream(STUDENTS_FILE);
            ObjectInputStream ois = new ObjectInputStream(fis);
            students = (List<Student>) ois.readObject();
            ois.close();
        } catch (Exception e){
            // ErrorHandler.text("Error while loading students.");
            return new ArrayList<Student>();
        }
        return students;
    }

    
    
    static void saveLecturers(List<Lecturer> lecturers) {
        try {
            FileOutputStream fos = new FileOutputStream(LECTURERS_FILE);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(lecturers);
            oos.close();
        } catch(Exception e) {
            ErrorHandler.text("Error while saving lecturers.");
        }
    }

    static List<Lecturer> loadLecturers() {
        List<Lecturer> lecturers = new ArrayList<Lecturer>();
        try {
            FileInputStream fis = new FileInputStream(LECTURERS_FILE);
            ObjectInputStream ois = new ObjectInputStream(fis);
            lecturers = (List<Lecturer>) ois.readObject();
            ois.close();
        } catch (Exception e){
            // ErrorHandler.text("Error while loading lecturers.");
            return new ArrayList<Lecturer>();
        }
        return lecturers;
    }

    
    
    static void saveStudentCourses(List<StudentCourse> studentCourses) {
        try {
            FileOutputStream fos = new FileOutputStream(STUDENT_COURSE_FILE);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(studentCourses);
            oos.close();
        } catch(Exception e) {
            ErrorHandler.text("Error while saving student-course associations.");
        }
    }

    static List<StudentCourse> loadStudentCourses() {
        List<StudentCourse> studentCourses = new ArrayList<StudentCourse>();
        try {
            FileInputStream fis = new FileInputStream(STUDENT_COURSE_FILE);
            ObjectInputStream ois = new ObjectInputStream(fis);
            studentCourses = (List<StudentCourse>) ois.readObject();
            ois.close();
        } catch (Exception e){
            // ErrorHandler.text("Error while loading student-course associations.");
            return new ArrayList<StudentCourse>();
        }
        return studentCourses;
    }

    
    
    static void saveLecturerCourses(List<LecturerCourse> lecturerCourses) {
        try {
            FileOutputStream fos = new FileOutputStream(LECTURER_COURSE_FILE);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(lecturerCourses);
            oos.close();
        } catch(Exception e) {
            ErrorHandler.text("Error while saving lecturer-course associations.");
        }
    }

    static List<LecturerCourse> loadLecturerCourses() {
        List<LecturerCourse> lecturerCourses = new ArrayList<LecturerCourse>();
        try {
            FileInputStream fis = new FileInputStream(LECTURER_COURSE_FILE);
            ObjectInputStream ois = new ObjectInputStream(fis);
            lecturerCourses = (List<LecturerCourse>) ois.readObject();
            ois.close();
        } catch (Exception e){
            // ErrorHandler.text("Error while loading lecturer-course associations.");
            return new ArrayList<LecturerCourse>();
        }
        return lecturerCourses;
    }


}