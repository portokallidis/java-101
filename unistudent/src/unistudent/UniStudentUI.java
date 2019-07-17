package unistudent;

import java.util.Scanner;

public class UniStudentUI {

    public static void init(UniStudent US) {
        int option;
        Scanner scan = new Scanner(System.in);

        System.out.println();
        System.out.println("=== UNISTUDENT Main Menu ===");
        System.out.println();
        System.out.println("Choose option 1-8");
        System.out.println("1. Manage Students");
        System.out.println("2. Manage Lecturers");
        System.out.println("3. Manage Courses");
        System.out.println("4. Assign Course to Lecturer");
        System.out.println("5. Assign Course to Student");
        System.out.println("6. Enter a Student grade for a Course");
        System.out.println("7. Display statistics");
        System.out.println("8. Save and Exit");

        option = scan.nextInt();

        switch (option) {
            case 1:
                UniStudentUI.manageStudents(US);
                break;
            case 2:
                UniStudentUI.manageLecturers(US);
                break;
            case 3:
                UniStudentUI.manageCourses(US);
                break;
            case 4:
                UniStudentUI.assignCourseToLecturer(US);
                break;
            case 5:
                UniStudentUI.assignCourseToStudent(US);
                break;
            case 6:
                UniStudentUI.enterStudentGradeForCourse(US);
                break;
            case 7:
                UniStudentUI.displayStatistics(US);
                break;
            case 8:
                US.saveData();
                System.out.println("GoodBye!");
                break;
                default:
                UniStudentUI.init(US);
                break;
        }
    }
    


    /**
     * MANAGE STUDENTS
     */
    
    static void manageStudents(UniStudent US){
        int option;
        Scanner scan = new Scanner(System.in);

        System.out.println();
        System.out.println("=== UNISTUDENT Manage Students ===");
        System.out.println();
        System.out.println("Choose option 1-4");
        System.out.println("1. List Students");
        System.out.println("2. Add Student");
        System.out.println("3. Edit/Delete Student");
        System.out.println("4. Back to main menu");

        option = scan.nextInt();

        switch (option) {
            case 1:
                System.out.print(US.listStudents());
                UniStudentUI.manageStudents(US);
                break;
            case 2:
                addStudent(US);
                break;
            case 3:
                editStudent(US);
                break;
            case 4:
            default:
                UniStudentUI.init(US);
                break;
        }

    }

    static void addStudent(UniStudent US) {
        String name="", email="", phone="", semester="";
        boolean error = false;  
        Scanner scan = new Scanner(System.in);
        System.out.println("=== Add new Student ===");
        System.out.println("** Enter no value to return back");

        System.out.println("Give student name(*): ");
        do {
            error = false;
            try {
                name = scan.nextLine();
            } catch(Exception e){
                ErrorHandler.text("Wrong input");
                scan.next();
                error = true;
            }
        } while (error);
        if (name.equals("")) {
            manageStudents(US);
            return;
        }

        do {
            System.out.println("Give student email(*): ");
            error = false;
            try {
                email = scan.nextLine();
            }
            catch(Exception e){
                ErrorHandler.text("Wrong input");
                scan.next();
            }
        } while (error);
        if (email.equals("")) {
            manageStudents(US);
            return;
        }
        
        System.out.println("Give student phone: ");
        phone = scan.nextLine();
        
        System.out.println("Give student semester(*): ");
        semester = scan.nextLine();
        if (semester==null) {
            manageStudents(US);
            return;
        }
        
        Student student = US.addStudent(name, phone, email, semester);
        System.out.println("Student (" + name + ") added with ID=("+student.getId()+")");

        UniStudentUI.init(US);
    }

    static void editStudent(UniStudent US) {

        Scanner scan = new Scanner(System.in);
        int id=0;
        Student c;
        int option;
        boolean exists = false;
        boolean error = false;
        System.out.println("=== Edit Student === ");
        System.out.print(US.listStudents());
        do {
            System.out.println("Edit student by ID: ");
            error = false;
            try {
                id = scan.nextInt();
            } catch(Exception e) {
                error = true;
                ErrorHandler.text("Wrong input");
                scan.next();
            }
        } while (error);
        try {
            c = US.getStudent(id);
            if (c.getId()==id) {
            System.out.println("User found: ");
            editStudentOptions(US, c);
            } 
        } catch(Exception e) {
            ErrorHandler.text("Not Found");
            manageStudents(US);
        }

    }

    static void editStudentOptions(UniStudent US, Student c) {
        Scanner scan = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in);
        String input;
        int option;
        System.out.println(c.show());
        System.out.println("Choose option: [1-6]");
        System.out.println("1.edit name");
        System.out.println("2.edit phone");
        System.out.println("3.edit email");
        System.out.println("4.edit semester");
        System.out.println("5.DELETE STUDENT");
        System.out.println("6.Back to main menu");
        option = scan.nextInt();
        System.out.println();

        switch (option) {
            case 1:
                System.out.println("Enter new name: ");
                input = scan2.nextLine();
                c.setName(input);
                System.out.println("Name updated to " + input);
                editStudentOptions(US, c);
                break;

            case 2:
                System.out.println("Enter new phone: ");
                input = scan2.nextLine();
                c.setPhone(input);
                System.out.println("Phone updated to " + input);
                editStudentOptions(US, c);
                break;

            case 3:
                System.out.println("Enter new email: ");
                input = scan2.nextLine();
                c.setEmail(input);
                System.out.println("Email updated to " + input);
                editStudentOptions(US, c);
                break;

            case 4:
                System.out.println("Enter new semester: ");
                input = scan2.nextLine();
                c.setSemester(input);
                System.out.println("Semester updated to " + input);
                editStudentOptions(US, c);
                break;

            case 5:
                US.remvoveStudent(c.getId());
                System.out.println("Student ("+c.getId()+") deleted");
                manageStudents(US);
                break;

            case 6:
                UniStudentUI.init(US);
                break;

        }

    }

    

    
    /**
     * MANAGE LECTURERS
     */
    static void manageLecturers(UniStudent US){
        int option;
        Scanner scan = new Scanner(System.in);

        System.out.println();
        System.out.println("=== UNILECTURER Manage Lecturers ===");
        System.out.println();
        System.out.println("Choose option 1-4");
        System.out.println("1. List Lecturers");
        System.out.println("2. Add Lecturer");
        System.out.println("3. Edit/Delete Lecturer");
        System.out.println("4. Back to main menu");

        option = scan.nextInt();

        switch (option) {
            case 1:
                System.out.print(US.listLecturers());
                UniStudentUI.manageLecturers(US);
                break;
            case 2:
                addLecturer(US);
                break;
            case 3:
                editLecturer(US);
                break;
            case 4:
            default:
                UniStudentUI.init(US);
                break;
        }

    }

    static void addLecturer(UniStudent US) {
        String name="", email="", phone="", scientificField="";
        boolean error = false;  
        Scanner scan = new Scanner(System.in);
        System.out.println("=== Add new Lecturer ===");
        System.out.println("** Enter no value to return back");

        System.out.println("Give lecturer name(*): ");
        do {
            error = false;
            try {
                name = scan.nextLine();
            } catch(Exception e){
                ErrorHandler.text("Wrong input");
                scan.next();
                error = true;
            }
        } while (error);
        if (name.equals("")) {
            manageLecturers(US);
            return;
        }

        do {
            System.out.println("Give lecturer email(*): ");
            error = false;
            try {
                email = scan.nextLine();
            }
            catch(Exception e){
                ErrorHandler.text("Wrong input");
                scan.next();
            }
        } while (error);
        if (email.equals("")) {
            manageLecturers(US);
            return;
        }
        
        System.out.println("Give lecturer phone: ");
        phone = scan.nextLine();
        
        System.out.println("Give lecturer scientific Field: ");
        scientificField = scan.nextLine();
        
        Lecturer lecturer = US.addLecturer(name, phone, email, scientificField);
        System.out.println("Lecturer (" + name + ") added with ID=("+lecturer.getId()+")");

        UniStudentUI.init(US);
    }

    static void editLecturer(UniStudent US) {

        Scanner scan = new Scanner(System.in);
        int id=0;
        Lecturer c;
        int option;
        boolean exists = false;
        boolean error = false;
        System.out.println("=== Edit Lecturer === ");
        do {
            System.out.println("Edit lecturer by ID: ");
            error = false;
            try {
                id = scan.nextInt();
            } catch(Exception e) {
                error = true;
                ErrorHandler.text("Wrong input");
                scan.next();
            }
        } while (error);
        try {
            c = US.getLecturer(id);
            if (c.getId()==id) {
            System.out.println("User found: ");
            editLecturerOptions(US, c);
            } 
        } catch(Exception e) {
            ErrorHandler.text("Not Found");
            manageLecturers(US);
        }

    }

    static void editLecturerOptions(UniStudent US, Lecturer c) {
        Scanner scan = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in);
        String input;
        int option;
        System.out.println(c.show());
        System.out.println("Choose option: [1-5]");
        System.out.println("1.edit name");
        System.out.println("2.edit phone");
        System.out.println("3.edit email");
        System.out.println("4.DELETE LECTURER");
        System.out.println("5.Back to main menu");
        option = scan.nextInt();
        System.out.println();

        switch (option) {
            case 1:
                System.out.println("Enter new name: ");
                input = scan2.nextLine();
                c.setName(input);
                System.out.println("Name updated to " + input);
                editLecturerOptions(US, c);
                break;

            case 2:
                System.out.println("Enter new phone: ");
                input = scan2.nextLine();
                c.setPhone(input);
                System.out.println("Phone updated to " + input);
                editLecturerOptions(US, c);
                break;

            case 3:
                System.out.println("Enter new email: ");
                input = scan2.nextLine();
                c.setEmail(input);
                System.out.println("Email updated to " + input);
                editLecturerOptions(US, c);
                break;
                
            case 4:
                US.removeLecturer(c.getId());
                System.out.println("Lecturer ("+c.getId()+") deleted");
                manageLecturers(US);
                break;

            case 5:
                UniStudentUI.init(US);
                break;

        }

    }



    /**
     * MANAGE COURSES
     */

    static void manageCourses(UniStudent US){
        int option;
        Scanner scan = new Scanner(System.in);

        System.out.println();
        System.out.println("=== UNISTUDENT Manage Courses ===");
        System.out.println();
        System.out.println("Choose option 1-4");
        System.out.println("1. List Courses");
        System.out.println("2. Add Course");
        System.out.println("3. Edit/Delete Course");
        System.out.println("4. Back to main menu");

        option = scan.nextInt();

        switch (option) {
            case 1:
                System.out.print(US.listCourses());
                UniStudentUI.manageCourses(US);
                break;
            case 2:
                addCourse(US);
                break;
            case 3:
                editCourse(US);
                break;
            case 4:
            default:
                UniStudentUI.init(US);
                break;
        }

    }

    static void addCourse(UniStudent US) {
        String title="", semester="";
        boolean error = false;  
        Scanner scan = new Scanner(System.in);
        System.out.println("=== Add new Course ===");
        System.out.println("** Enter no value to return back");

        System.out.println("Give course title(*): ");
        do {
            error = false;
            try {
                title = scan.nextLine();
            } catch(Exception e){
                ErrorHandler.text("Wrong input");
                scan.next();
                error = true;
            }
        } while (error);
        if (title.equals("")) {
            manageCourses(US);
            return;
        }
        
        System.out.println("Give course semester(*): ");
        semester = scan.nextLine();
        if (semester==null) {
            manageCourses(US);
            return;
        }
        
        Course course = US.addCourse(title, semester);
        System.out.println("Course (" + title + ") added with ID=("+course.getId()+")");

        UniStudentUI.init(US);
    }

    static void editCourse(UniStudent US) {

        Scanner scan = new Scanner(System.in);
        int id=0;
        Course c;
        int option;
        boolean exists = false;
        boolean error = false;
        System.out.println("=== Edit Course === ");
        do {
            System.out.println("Edit course by ID: ");
            error = false;
            try {
                id = scan.nextInt();
            } catch(Exception e) {
                error = true;
                ErrorHandler.text("Wrong input");
                scan.next();
            }
        } while (error);
        try {
            c = US.getCourse(id);
            if (c.getId()==id) {
            System.out.println("Course found: ");
            editCourseOptions(US, c);
            } 
        } catch(Exception e) {
            ErrorHandler.text("Not Found");
            manageCourses(US);
        }

    }

    static void editCourseOptions(UniStudent US, Course c) {
        Scanner scan = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in);
        String input;
        int option;
        System.out.println(c.show());
        System.out.println("Choose option: [1-4]");
        System.out.println("1.edit title");
        System.out.println("2.edit semester");
        System.out.println("3.DELETE STUDENT");
        System.out.println("4.Back to main menu");
        option = scan.nextInt();
        System.out.println();

        switch (option) {
            case 1:
                System.out.println("Enter new title: ");
                input = scan2.nextLine();
                c.setTitle(input);
                System.out.println("Title updated to " + input);
                editCourseOptions(US, c);
                break;
                
            case 2:
                System.out.println("Enter new semester: ");
                input = scan2.nextLine();
                c.setSemester(input);
                System.out.println("Semester updated to " + input);
                editCourseOptions(US, c);
                break;

            case 3:
                US.removeCourse(c.getId());
                System.out.println("Course ("+c.getId()+") deleted");
                manageCourses(US);
                break;

            case 4:
                UniStudentUI.init(US);
                break;

        }

    }



    /**
     * STATISTICS
     *      
     * */
    
    static void displayStatistics(UniStudent US) {
        
        int option;
        Scanner scan = new Scanner(System.in);

        System.out.println();
        System.out.println("=== UNISTUDENT Statistics ===");
        System.out.println();
        System.out.println("Choose option 1-4");
        System.out.println("1. Mean grade per course");
        System.out.println("2. Mean grade per student");
        System.out.println("3. Students - Mean grade chart");
        System.out.println("4. Courses - Mean grade chart");
        System.out.println("5. Back to main menu");

        option = scan.nextInt();

        switch (option) {
            case 1:
                US.showCoursesWithMeanGrade();
                UniStudentUI.displayStatistics(US);
                break;
            case 2:
                US.showStudentsWithMeanGrade();
                UniStudentUI.displayStatistics(US);
                break;
            case 3:
                System.out.println("=== Students Chart ===");
                US.showStudentGraphWithMeanGrade();
                UniStudentUI.displayStatistics(US);
                break;
            case 4:
            System.out.println("=== Courses Chart ===");
                US.showCourseGraphWithMeanGrade();
                UniStudentUI.displayStatistics(US);
                break;
            case 5:
            default:
                UniStudentUI.init(US);
                break;
        }
    };

    


    /**
     * Other methods
     */

     

    static void assignCourseToStudent(UniStudent US) {

        Scanner scan = new Scanner(System.in);
        int idc=0,ids=0;
        Course c=null;
        Student s=null;
        int option;
        boolean exists = false;
        boolean error = false;
        System.out.println("=== Assign Course to Student === ");
        System.out.print(US.listStudents());
        do {
            System.out.println("Select student by ID: ");
            error = false;
            try {
                ids = scan.nextInt();
            } catch(Exception e) {
                error = true;
                ErrorHandler.text("Wrong input");
                scan.next();
            }
        } while (error);
        try {
            s = US.getStudent(ids);
            if (s.getId()==ids) {
                System.out.println("Selected student: "+s.show());
            } 
        } catch(Exception e) {
            ErrorHandler.text("Student not Found");
            UniStudentUI.init(US);
            return;
        }


        System.out.print(US.listCourses());
        do {
            System.out.println("Select course by ID: ");
            error = false;
            try {
                idc = scan.nextInt();
            } catch(Exception e) {
                error = true;
                ErrorHandler.text("Wrong input");
                scan.next();
            }
        } while (error);
        try {
            c = US.getCourse(idc);
            if (c.getId()==idc) {
                US.assignCourseToStudent(ids,idc);
                System.out.println("Course: "+c.show());
                System.out.println("Assigned to student : "+s.show());
                UniStudentUI.init(US);
            } 
        } catch(Exception e) {
            ErrorHandler.text(e.toString());
            ErrorHandler.text("Course not Found");
            UniStudentUI.init(US);
            return;
        }

    }

    static void assignCourseToLecturer(UniStudent US) {

        Scanner scan = new Scanner(System.in);
        int idc=0,ids=0;
        Course c=null;
        Lecturer s=null;
        int option;
        boolean exists = false;
        boolean error = false;
        System.out.println("=== Assign Course to Lecturer === ");
        System.out.print(US.listLecturers());
        do {
            System.out.println("Select student by ID: ");
            error = false;
            try {
                ids = scan.nextInt();
            } catch(Exception e) {
                error = true;
                ErrorHandler.text("Wrong input");
                scan.next();
            }
        } while (error);
        try {
            s = US.getLecturer(ids);
            if (s.getId()==ids) {
                System.out.println("Selected student: "+s.show());
            } 
        } catch(Exception e) {
            ErrorHandler.text("Lecturer not Found");
            UniStudentUI.init(US);
        }


        System.out.print(US.listCourses());
        do {
            System.out.println("Select course by ID: ");
            error = false;
            try {
                idc = scan.nextInt();
            } catch(Exception e) {
                error = true;
                ErrorHandler.text("Wrong input");
                scan.next();
            }
        } while (error);
        try {
            c = US.getCourse(idc);
            if (c.getId()==idc) {
                US.assignCourseToLecturer(ids,idc);
                System.out.println("Course: "+c.show());
                System.out.println("Assigned to student : "+s.show());
                UniStudentUI.init(US);
            } 
        } catch(Exception e) {
            ErrorHandler.text("Course not Found");
            UniStudentUI.init(US);
        }

    }

    static void enterStudentGradeForCourse(UniStudent US) {

        Scanner scan = new Scanner(System.in);
        int grade=0,idc=0, ids=0;
        Course c=null;
        Student s=null;
        StudentCourse sc=null;
        int option;
        boolean exists = false;
        boolean error = false;
        System.out.println("=== Student Grades === ");
        System.out.print(US.listStudents());
        do {
            System.out.println("Select student by ID: ");
            error = false;
            try {
                ids = scan.nextInt();
            } catch(Exception e) {
                error = true;
                ErrorHandler.text("Wrong input");
                scan.next();
            }
        } while (error);
        try {
            s = US.getStudent(ids);
            if (s.getId()==ids) {
                System.out.println("Selected student: "+s.show());
            } 
        } catch(Exception e) {
            ErrorHandler.text("Student not Found");
            UniStudentUI.init(US);
            return;
        }

        try {
            System.out.print(US.listStudentCourses(ids));
        } catch(Exception e) {
            ErrorHandler.text("Student has not been registered to any course.");
            UniStudentUI.init(US);
            return;
        }
        
        do {
            System.out.println("Select course by ID: ");
            error = false;
            try {
                idc = scan.nextInt();
            } catch(Exception e) {
                error = true;
                ErrorHandler.text("Wrong input");
                scan.next();
            }
        } while (error);
        try {
            c = US.getCourse(idc);
            if (c.getId()==idc) {
                System.out.println("Selected Course: "+c.show());
            } 
        } catch(Exception e) {
            ErrorHandler.text("Course not Found");
            UniStudentUI.init(US);
            return;
        }
        
        try {        
            sc = US.getStudentCourse(ids,idc);
            sc.getStudentId();
        }  catch(Exception e) {
            ErrorHandler.text("Student("+ids+") has not been registered to course ("+idc+")");
            UniStudentUI.init(US);
            return;
        }

        do {
            System.out.println("Enter grade : ");
            error = false;
            try {
                grade = scan.nextInt();
            } catch(Exception e) {
                error = true;
                ErrorHandler.text("Wrong input, only integers are allowed.");
                scan.next();
            }
        } while (error);
        
        
        US.setStudentGradeForCourse(ids,idc,grade);
        System.out.println("Grade:"+grade + " has been set." );
        UniStudentUI.init(US);

    }


}
