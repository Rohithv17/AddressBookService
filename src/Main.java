import com.bridgelabz.addressbookservice.AddressBook;
import com.bridgelabz.addressbookservice.Contacts;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AddressBook addressBook = new AddressBook();

        while (true) {
            System.out.println("Address Book Menu:");
            System.out.println("1. Add Contact");
            System.out.println("2. Delete Contact");
            System.out.println("3. View Contacts");
            System.out.println("4. Exit ");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {   // to give options for users to choose actions to be performed
                System.out.print("Enter first name: ");
                String firstName = scanner.nextLine();
                System.out.print("Enter last name: ");
                String lastName = scanner.nextLine();
                System.out.print("Enter address: ");
                String address = scanner.nextLine();
                System.out.print("Enter city: ");
                String city = scanner.nextLine();
                System.out.print("Enter state: ");
                String state = scanner.nextLine();
                System.out.print("Enter ZIP: ");
                String zip = scanner.nextLine();
                System.out.print("Enter phone number: ");
                String phoneNumber = scanner.nextLine();
                System.out.print("Enter email: ");
                String email = scanner.nextLine();

                Contacts newContact = new Contacts(firstName, lastName, address, city, state, zip, phoneNumber, email);
                addressBook.addContact(newContact);
                System.out.println("Contact added successfully!\n");
            } else if (choice == 2) {
                System.out.print("Enter first name of the contact to delete: ");
                String deleteFirstName = scanner.nextLine();
                System.out.print("Enter last name of the contact to delete: ");
                String deleteLastName = scanner.nextLine();
                addressBook.deleteContact(deleteFirstName, deleteLastName);


            } else if (choice == 3) {
                addressBook.displayContacts();
            } else if (choice == 4) {
                System.out.println("Exiting program...");
                break;
            } else {
                System.out.println("Invalid choice. Please enter a valid option.\n");
            }
        }
    }
}