import com.bridgelabz.addressbookservice.AddressBook;
import com.bridgelabz.addressbookservice.Contacts;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import static com.bridgelabz.addressbookservice.AddressBook.searchByCityAcrossAddressBooks;
import static com.bridgelabz.addressbookservice.AddressBook.searchByStateAcrossAddressBooks;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, AddressBook> addressBooks = new HashMap<>();

        while (true) {                                        // for creation and selection of address book
            System.out.println("Address Book System:");
            System.out.println("1. Create New Address Book");
            System.out.println("2. Select Address Book");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.print("Enter address book name: ");
                String name = scanner.nextLine();
                if (addressBooks.containsKey(name)) {
                    System.out.println("Address book with that name already exists!");
                } else {
                    addressBooks.put(name, new AddressBook());
                    System.out.println("Address book created successfully!");
                }
            } else if (choice == 2) {
                if (addressBooks.isEmpty()) {
                    System.out.println("No address books exist!");
                } else {
                    System.out.println("Available address books:");
                    for (String name : addressBooks.keySet()) {
                        System.out.println("- " + name);
                    }
                    System.out.print("Enter address book name: ");
                    String name = scanner.nextLine();
                    if (addressBooks.containsKey(name)) {
                        AddressBook selectedAddressBook = addressBooks.get(name);
                        // Use selectedAddressBook to manage contacts
                        manageAddressBook(selectedAddressBook, scanner);
                    } else {
                        System.out.println("Invalid address book name!");
                    }
                }
            } else if (choice == 3) {
                System.out.println("Exiting program...");
                break;
            } else {
                System.out.println("Invalid choice. Please enter a valid option.\n");
            }
        }
    }

    // Function to search for the person by city/state
    public static void searchPerson(List<AddressBook> addressBooks, Scanner scanner) {
        System.out.println("Search Person:");
        System.out.println("1. By City");
        System.out.println("2. By State");
        System.out.print("Enter your choice: ");
        int searchChoice = scanner.nextInt();
        scanner.nextLine();

        if (searchChoice == 1) {
            System.out.print("Enter city to search: ");
            String city = scanner.nextLine();
            List<Contacts> personsInCity = searchByCityAcrossAddressBooks(addressBooks, city);
            displaySearchResults(personsInCity, "city", city);
        } else if (searchChoice == 2) {
            System.out.print("Enter state to search: ");
            String state = scanner.nextLine();
            List<Contacts> personsInState = searchByStateAcrossAddressBooks(addressBooks, state);
            displaySearchResults(personsInState, "state", state);
        } else {
            System.out.println("Invalid choice for search.");
        }
    }

    //To display the results
    public static void displaySearchResults(List<Contacts> searchResults, String searchType, String searchTerm) {
        if (searchResults.isEmpty()) {
            System.out.println("No person found in the " + searchType + ": " + searchTerm);
        } else {
            System.out.println("Persons found in the " + searchType + " " + searchTerm + ":");
            searchResults.forEach(System.out::println);
        }
    }


    public static void manageAddressBook(AddressBook selectedAddressBook, Scanner scanner) { // specifies operations to perform on the selected address book

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