package com.bridgelabz.addressbookservice;

import java.util.*;
import java.util.stream.Collectors;

public class AddressBook {
    private Set<Contacts> contacts;



    public AddressBook() {
        contacts = new HashSet<>();

    }

    public void addContact(Contacts contact) {
        contacts.add(contact);
        if (hasDuplicate(contact.getFirstName(), contact.getLastName())) {
            return; // Prevent duplicate addition
        }
        contacts.add(contact);
        System.out.println("Contact added successfully!\n");
    }

    public boolean hasDuplicate(String firstName, String lastName) {   // to check for duplicates
        return contacts.stream().anyMatch(c -> c.getFirstName().equals(firstName) && c.getLastName().equals(lastName));
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
    // Method to search for a person by city across multiple address books
    public static List<Contacts> searchByCityAcrossAddressBooks(List<AddressBook> addressBooks, String city) {
        return addressBooks.stream()
                .flatMap(addressBook -> addressBook.contacts.stream())
                .filter(contact -> contact.getCity().equalsIgnoreCase(city))
                .collect(Collectors.toList());
    }

    // Method to search for a person by state across multiple address books
    public static List<Contacts> searchByStateAcrossAddressBooks(List<AddressBook> addressBooks, String state) {
        return addressBooks.stream()
                .flatMap(addressBook -> addressBook.contacts.stream())
                .filter(contact -> contact.getState().equalsIgnoreCase(state))
                .collect(Collectors.toList());

}

    public Contacts findContactByName(String firstName, String lastName) {
        for (Contacts contact : contacts) {
            if (contact.getFirstName().equals(firstName) && contact.getLastName().equals(lastName)) {
                return contact;
            }
        }
        return null; // Contact not found
    }

    //  to edit contacts
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
    public void deleteContact(String firstName, String lastName) { // To delete the contacts
        Iterator<Contacts> iterator = contacts.iterator();
        while (iterator.hasNext()) {
            Contacts contact = iterator.next();
            if (contact.getFirstName().equals(firstName) && contact.getLastName().equals(lastName)) {
                iterator.remove();
                System.out.println("Contact deleted successfully!\n");
                return;
            }

}}}


