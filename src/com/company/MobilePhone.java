package com.company;

import java.util.ArrayList;

public class MobilePhone {

    ArrayList<Contacts> contacts = new ArrayList<Contacts>();

    public void modifyContact(String oldName, String newName, String newNumber){
        int position = findContact(oldName);
        if (onFile(oldName)) {
            Contacts newContact = new Contacts(newName, newNumber);
            contacts.set(position,newContact);
            System.out.println(oldName + " has been updated with " + newName + ": " + newNumber);
        } else {
            System.out.println("Contact could not be found.");
        }
    }

    public void removeContact(String contact){
        int position = findContact(contact);
        if (position >= 0) {
            removeContact(position);
        }
    }

    private void removeContact(int position) { contacts.remove(position); }

    private int findContact(String contactName) {
        for (int i = 0; i < contacts.size(); i++) {
            Contacts contact = this.contacts.get(i);
            if(contact.getName().equals(contactName)) {
                return i;
            }
        }
        return -1;
    }

    public boolean onFile(String name) {
        int position = findContact(name);
        if (position >= 0) {
            return true;
        }
        return false;
    }

    public void addNewContact(String name, String number) {
        Contacts contact = new Contacts(name, number);
        contacts.add(contact);
    }

    public void printContactsHere() {
        printContacts();
    }

    private void printContacts() {
        for (int i = 0; i < contacts.size(); i++) {
            System.out.println("Name: " + contacts.get(i).getName());
            System.out.println("Number: " + contacts.get(i).getNumber() + "\n");
        }
    }
}
