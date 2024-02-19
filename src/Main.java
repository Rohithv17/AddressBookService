import com.bridgelabz.addressbookservice.AddressBook;
import com.bridgelabz.addressbookservice.Contacts;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AddressBook addressBook = new AddressBook();

        while (true) {                                //options for user to choice
            System.out.println("Address Book Menu:");
            System.out.println("1. Add Contact");
            System.out.println("2. Edit Contact");
            System.out.println("3. View Contacts");
            System.out.println("4. Exit ");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                // Add multiple contacts until user chooses to stop
                while (true) {
                    System.out.print("Enter first name (or 'q' to quit): ");
                    String firstName = scanner.nextLine();
                    if (firstName.equalsIgnoreCase("q")) {
                        break;
                    }

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
                }
            } else if (choice == 2) {
                System.out.print("Enter first name of the contact to edit: ");
                String editFirstName = scanner.nextLine();
                System.out.print("Enter last name of the contact to edit: ");
                String editLastName = scanner.nextLine();

                Contacts contactToEdit = addressBook.findContactByName(editFirstName, editLastName);
                if (contactToEdit != null) {
                    System.out.print("Enter new first name: ");
                    String newFirstName = scanner.nextLine();
                    System.out.print("Enter new last name: ");
                    String newLastName = scanner.nextLine();
                    System.out.print("Enter new address: ");
                    String newAddress = scanner.nextLine();
                    System.out.print("Enter new city: ");
                    String newCity = scanner.nextLine();
                    System.out.print("Enter new state: ");
                    String newState = scanner.nextLine();
                    System.out.print("Enter new ZIP: ");
                    String newZip = scanner.nextLine();
                    System.out.print("Enter new phone number: ");
                    String newPhoneNumber = scanner.nextLine();
                    System.out.print("Enter new email: ");
                    String newEmail = scanner.nextLine();

                    addressBook.editContact(contactToEdit, newFirstName, newLastName, newAddress, newCity, newState, newZip, newPhoneNumber, newEmail);
                    System.out.println("Contact edited successfully!\n");
                } else {
                    System.out.println("Contact not found.\n");
                }
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