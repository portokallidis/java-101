package unistudent;

import java.util.Scanner;
import java.util.Iterator;

public class UniStudentUI {

    public static void init(UniStudent US) {
        int option;
        Scanner scan = new Scanner(System.in);

        System.out.println();
        System.out.println("=== Address Book Main Menu===");
        System.out.println("** Enter no value to return back to main menu");
        System.out.println();
        System.out.println("Choose option 1-7");
        System.out.println("1. All contacts");
        System.out.println("2. Add contact");
        System.out.println("3. Search contact by name");
        System.out.println("4. Search contact by phone");
        System.out.println("5. Edit contact");
        System.out.println("6. Delete contact");
        System.out.println("7. Exit");

        option = scan.nextInt();

        switch (option) {
            case 1:
            UniStudentUI.displayAllContacts(US);
                break;
            case 2:
            UniStudentUI.addContact(US);
                break;
            case 3:
            UniStudentUI.searchContactByName(US);
                break;
            case 4:
            UniStudentUI.searchContactByPhone(US);
                break;
            case 5:
            UniStudentUI.editContact(US);
                break;
            case 6:
            UniStudentUI.deleteContact(US);
                break;
            case 7:
                System.out.println("GoodBye!");
                break;
            default:
            UniStudentUI.init(US);

        }
    }

    private static void addContact(UniStudent US) {
        String name, phone, email, address;
        boolean exists;
        Scanner scan = new Scanner(System.in);
        System.out.println("=== Add new Contact ===");


        do {
            System.out.println("Give contact name: ");
            name = scan.nextLine();
            if (name.equals("")) {
                UniStudentUI.init(US);
                return;
            }
            if (US.hasContact(name)) exists = true;
            else exists = false;
            if (exists) {
                System.out.println("Contact with name (" + name + ") already exists");
            }
        } while (exists);

        do {
            System.out.println("Give contact phone: ");
            phone = scan.nextLine();
            if (phone.equals("")) {
                UniStudentUI.init(US);
                return;
            }
            exists = US.hasContactByPhone(phone);
            if (exists) {
                System.out.println("Contact with phone (" + phone + ") already exists");
            }
        } while (exists);

        System.out.println("Give contact email: ");
        email = scan.nextLine();
        if (email.equals("")) {
            UniStudentUI.init(US);
            return;
        }

        System.out.println("Give contact address: ");
        address = scan.nextLine();
        if (address.equals("")) {
            UniStudentUI.init(US);
            return;
        }

        US.addContact(name, phone, email, address);
        System.out.println("Contact (" + name + ") added!");

        UniStudentUI.init(US);
    }

    private static void editContact(UniStudent US) {

        Scanner scan = new Scanner(System.in);
        String name, input;
        Contact c;
        int option;
        boolean exists;
        System.out.println("=== Edit Contact === ");
        do {
            System.out.println("Edit contact by name: ");
            name = scan.nextLine();
            if (name.equals("")) {
                UniStudentUI.init(US);
                return;
            }
            exists = US.hasContact(name);
            if (exists) {
                c = US.getContact(name);
                UniStudentUI.editContactOptions(US, c);
            } else {
                System.out.println("Not found!");
            }
        } while (!exists);
    }


    private static void editContactOptions(UniStudent US, Contact c) {
        Scanner scan = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in);
        String input;
        int option;
        System.out.println(c.show());
        System.out.println("Choose option: [1-5]");
        System.out.println("1.edit name");
        System.out.println("2.edit phone");
        System.out.println("3.edit email");
        System.out.println("4.edit address");
        System.out.println("5.Back to main menu");
        option = scan.nextInt();
        System.out.println();

        switch (option) {
            case 1:
                System.out.println("Enter new name: ");
                input = scan2.nextLine();
                US.editContactName(c.getName(), input);
                System.out.println("Name updated to " + input);
                UniStudentUI.editContactOptions(US, c);
                break;

            case 2:
                System.out.println("Enter new phone: ");
                input = scan2.nextLine();
                US.editContactPhone(c.getPhone(), input);
                System.out.println("Phone updated to " + input);
                UniStudentUI.editContactOptions(US, c);
                break;

            case 3:
                System.out.println("Enter new email: ");
                input = scan2.nextLine();
                c.editEmail(input);
                System.out.println("Email updated to " + input);
                UniStudentUI.editContactOptions(US, c);
                break;

            case 4:
                System.out.println("Enter new address: ");
                input = scan2.nextLine();
                c.editAddress(input);
                System.out.println("Address updated to " + input);
                UniStudentUI.editContactOptions(US, c);
                break;

            case 5:
                UniStudentUI.init(US);
                break;

        }

    }

    private static void deleteContact(UniStudent US) {
        Scanner scan = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in);
        String name;
        int option;
        boolean result;
        boolean exists;
        System.out.println("=== Delete Contact === ");
        do {
            System.out.println("Edit contact by name: ");
            name = scan.nextLine();
            if (name.equals("")) {
                UniStudentUI.init(US);
                return;
            }
            exists = US.hasContact(name);
            if (exists) {
                do {
                    System.out.println(US.getContact(name).show());
                    System.out.println("Choose option: [1-2]");
                    System.out.println("1.DELETE CONTACT");
                    System.out.println("2.Cancel");
                    option = scan.nextInt();

                    switch (option) {
                        case 1:
                            result = US.deleteContact(name);
                            if (result) {
                                System.out.println("Contact (" + name + ") deleted.");
                                System.out.println();
                                System.out.println("Press enter to return to Main menu..");
                                scan2.nextLine();
                                UniStudentUI.init(US);
                            } else {
                                System.out.println("Contact (" + name + ") could not be deleted!");
                                System.out.println();
                                System.out.println("Press enter to return to Main menu..");
                                scan2.nextLine();
                                UniStudentUI.init(US);
                            }
                            return;
                        case 2:
                            System.out.println("Contact deletion canceled!");
                            UniStudentUI.init(US);
                            return;
                    }
                } while (option != 1);


            } else {
                System.out.println("Not found!");
            }
        } while (!exists);
    }

    private static void searchContactByName(UniStudent US) {
        Scanner scan = new Scanner(System.in);
        String name;
        boolean exists;
        System.out.println("=== Search === ");
        do {
            System.out.println("Search by contact name: ");
            name = scan.nextLine();
            if (name.equals("")) {
                UniStudentUI.init(US);
                return;
            }
            exists = US.hasContact(name);
            if (exists) {
                System.out.println(US.getContact(name).show());
                UniStudentUI.searchContactByName(US);
            } else {
                System.out.println("Not found!");
            }
        } while (!exists);
    }

    private static void searchContactByPhone(UniStudent US) {
        Scanner scan = new Scanner(System.in);
        String phone;
        boolean exists;
        System.out.println("=== Search === ");
        do {
            System.out.println("Search by phone number: ");
            phone = scan.nextLine();
            if (phone.equals("")) {
                UniStudentUI.init(US);
                return;
            }
            exists = US.hasContactByPhone(phone);
            if (exists) {
                System.out.println(US.getContactByPhone(phone).show());
                UniStudentUI.searchContactByPhone(US);
            } else {
                System.out.println("Not found!");
            }
        } while (!exists);
    }

    private static void displayAllContacts(UniStudent US) {
        Scanner scan = new Scanner(System.in);
        Iterator<Contact> all = US.getAllContacts();
        System.out.println("All Contacts: ");
        while (all.hasNext()) {
            Contact c = all.next();
            System.out.println(c.show());
        }
        System.out.println();
        System.out.println("Press enter to return to Main menu..");
        scan.nextLine();
        UniStudentUI.init(US);
    }
}
