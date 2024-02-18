package com.bridgelabz.addressbookservice;

public class Contacts {
       private String firstName;
        private String lastName;
        private String address;
        private String city;
        private String state;
        private String zip;
        private String phoneNumber;
        private String email;

        public Contacts(String firstName, String lastName, String address, String city, String state, String zip, String phoneNumber, String email) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.address = address;
            this.city = city;
            this.state = state;
            this.zip = zip;
            this.phoneNumber = phoneNumber;
            this.email = email;
        }

        @Override
        public String toString() {
            return "Name: " + firstName + " " + lastName +
                    "\nAddress: " + address +
                    "\nCity: " + city +
                    "\nState: " + state +
                    "\nZIP: " + zip +
                    "\nPhone: " + phoneNumber +
                    "\nEmail: " + email + "\n";
        }
    }


