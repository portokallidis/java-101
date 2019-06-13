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
                StudentsUI.manageStudents(US);
                break;
            case 2:
                // UniStudentUI.manageLecturers(US);
                break;
            case 3:
                // UniStudentUI.manageCourses(US);
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
    
    
}
