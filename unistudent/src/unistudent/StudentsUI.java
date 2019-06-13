package unistudent;

import java.util.Scanner;


public class StudentsUI {

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

}
