package com.bridgelabz.addressbookservice;

import java.util.*;

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


