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
                // UniStudentUI.assignCourseToLecturer(US);
                break;
            case 5:
                // UniStudentUI.assignCourseToStudent(US);
                break;
            case 6:
                // UniStudentUI.enterStudentGradeForCourse(US);
                break;
            case 7:
                // UniStudentUI.displayStatistics(US);
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



    
    // private static void displayAllStudents(UniStudent US) {
    //     Scanner scan = new Scanner(System.in);
    //     Iterator<Student> all = US.getAllStudents();
    //     System.out.println("All Students: ");
    //     while (all.hasNext()) {
    //         Student c = all.next();
    //         System.out.println(c.show());
    //     }
    //     System.out.println();
    //     System.out.println("Press enter to return to Main menu..");
    //     scan.nextLine();
    //     UniStudentUI.init(US);
    // }
    
    /**
     * MANAGE STUDENTS
     */
    
    static void manageStudents(UniStudent US){
        int option;
        Scanner scan = new Scanner(System.in);

        System.out.println();
        System.out.println("=== UNISTUDENT Manage Students ===");
        System.out.println();
        System.out.println("Choose option 1-3");
        System.out.println("1. Add Student");
        System.out.println("2. Edit/Delete Student");
        System.out.println("3. Back to main menu");

        option = scan.nextInt();

        switch (option) {
            case 1:
                addStudent(US);
                break;
            case 2:
                editStudent(US);
                break;
            case 3:
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
        System.out.println("Choose option 1-3");
        System.out.println("1. Add Lecturer");
        System.out.println("2. Edit/Delete Lecturer");
        System.out.println("3. Back to main menu");

        option = scan.nextInt();

        switch (option) {
            case 1:
                addLecturer(US);
                break;
            case 2:
                editLecturer(US);
                break;
            case 3:
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
        System.out.println("Choose option 1-3");
        System.out.println("1. Add Course");
        System.out.println("2. Edit/Delete Course");
        System.out.println("3. Back to main menu");

        option = scan.nextInt();

        switch (option) {
            case 1:
                addCourse(US);
                break;
            case 2:
                editCourse(US);
                break;
            case 3:
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


}
