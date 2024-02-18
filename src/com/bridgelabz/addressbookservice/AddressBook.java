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

}


