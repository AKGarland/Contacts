package com.company;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone();

    public static void main(String[] args) {
        int option = 0;
        boolean quit = false;

        menu();

        while(!quit) {
            System.out.println("Enter your choice from the menu: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch(option){
                case 0:
                    menu();
                    break;
                case 1:
                    printContacts();
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    findContact();
                    break;
                case 6:
                    quit = true;
                    break;
                default:
                    System.out.println("That is not an option.");
                    break;
            }

        }
    }

    public static void menu() {
        System.out.println("\n Options:");
        System.out.println("\t 0 - shows options");
        System.out.println("\t 1 - prints the list of contacts");
        System.out.println("\t 2 - adds a new contact");
        System.out.println("\t 3 - updates an existing contact");
        System.out.println("\t 4 - removes a contact");
        System.out.println("\t 5 - searches for a contact");
        System.out.println("\t 6 - quits application");
    }


    public static void printContacts() {
        System.out.println("Your contacts: ");
        mobilePhone.printContactsHere();
    }

    public static void addNewContact () {
        System.out.println("Input the contact name: ");
        String name = scanner.nextLine();
        if (!mobilePhone.onFile(name)) {
            System.out.println("Now input the contact number: ");
            String number = scanner.nextLine();
            mobilePhone.addNewContact(name, number);
            System.out.println("\n" + name + " has been added to your contact list.");
        } else {
            System.out.println("Contact by that name already exists.");
        }
    }

    public static void updateContact() {
        System.out.println("Input the name of the contact to update: ");
        String oldName = scanner.nextLine();
        boolean exists = mobilePhone.onFile(oldName);

        if (exists == true) {
            System.out.println("Input the name of the replacement contact: ");
            String newName = scanner.nextLine();

            System.out.println("Input the number of the contact to replace: ");
            String newNumber = scanner.nextLine();

            mobilePhone.modifyContact(oldName, newName, newNumber);
        } else {
            System.out.println("This contact could not be located, please choose another option.");
        }
    }

    public static void removeContact() {
        System.out.println("Input the name of the contact you would like to remove: ");
        String name = scanner.nextLine();
        mobilePhone.removeContact(name);
        System.out.println(name + " has been successfully removed.");
    }

    public static void findContact() {
        System.out.println("Input the name of the contact you would like to find: ");
        String name = scanner.nextLine();
        boolean found = mobilePhone.onFile(name);
        if(found){
            System.out.println(name + " has been located.");
        } else {
            System.out.println(name + " could not be found.");
        }
    }
}
