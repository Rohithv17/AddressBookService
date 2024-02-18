package com.bridgelabz.addressbookservice;

import java.util.ArrayList;
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
    }

