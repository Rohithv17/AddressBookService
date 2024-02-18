package com.bridgelabz.addressbookservice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AddressBook {

        private List<Contacts> contacts;

        public AddressBook() {
            contacts = new ArrayList<>();
        }

        public void addContact(Contacts contact) {
            contacts.add(contact);
        }

        public void displayContacts() {
            if (contacts.isEmpty()) {
                System.out.println("Address book is empty!");
            } else {
                for (Contacts contact : contacts) {
                    System.out.println(contact);
                }
            }
        }

    public Contacts findContactByName(String firstName, String lastName) {
        for (Contacts contact : contacts) {
            if (contact.getFirstName().equals(firstName) && contact.getLastName().equals(lastName)) {
                return contact;
            }
        }
        return null; // Contact not found
    }
//  to edit contacts using first and last name
    public void editContact(Contacts contact, String newFirstName, String newLastName, String newAddress,
                            String newCity, String newState, String newZip, String newPhoneNumber, String newEmail) {
        contact.setFirstName(newFirstName);
        contact.setLastName(newLastName);
        contact.setAddress(newAddress);
        contact.setCity(newCity);
        contact.setState(newState);
        contact.setZip(newZip);
        contact.setPhoneNumber(newPhoneNumber);
        contact.setEmail(newEmail);
    }
    public void deleteContact(String firstName, String lastName) { // To delete contact using first name and last name
        Iterator<Contacts> iterator = contacts.iterator();
        while (iterator.hasNext()) {
            Contacts contact = iterator.next();
            if (contact.getFirstName().equals(firstName) && contact.getLastName().equals(lastName)) {
                iterator.remove();
                System.out.println("Contact deleted successfully!\n");
                return;
            }
        }
        System.out.println("Contact not found.\n");
    }
}


