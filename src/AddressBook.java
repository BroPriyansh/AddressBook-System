import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBook {
    private final Scanner scanner;
    private final List<Contact> contacts;

    public AddressBook() {
        this.scanner = new Scanner(System.in);
        this.contacts = new ArrayList<>();
    }

    public void run() {
        while (true) {
            System.out.println("\n1. Add Contact");
            System.out.println("2. Edit Contact");
            System.out.println("3. Delete Contact");
            System.out.println("4. Display Contacts");
            System.out.println("5. Search Contact");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    addContact();
                    break;
                case "2":
                    editContact();
                    break;
                case "3":
                    deleteContact();
                    break;
                case "4":
                    displayContacts();
                    break;
                case "5":
                    searchContact();
                    break;
                case "6":
                    System.out.println("Exiting Address Book Program");
                    return;
                default:
                    System.out.println("Invalid choice. Please enter 1, 2, 3, 4, 5 or 6.");
            }
        }
    }

    public void addContact() {
        String firstName = readRequiredInput("Enter first name: ");
        String lastName = readRequiredInput("Enter last name: ");
        String address = readRequiredInput("Enter address: ");
        String city = readRequiredInput("Enter city: ");
        String state = readRequiredInput("Enter state: ");
        String zip = readRequiredInput("Enter zip: ");
        String phoneNumber = readValidPhoneNumber("Enter phone number: ");
        String email = readValidEmail("Enter email: ");

        Contact contact = new Contact(firstName, lastName, address, city, state, zip,
                phoneNumber, email);
        contacts.add(contact);
        System.out.println("Contact Added Successfully");
        System.out.println(contact);
    }

    public void editContact() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts available to edit.");
            return;
        }

        System.out.print("Enter first name of contact to edit: ");
        String firstName = scanner.nextLine().trim();

        for (Contact contact : contacts) {
            if (contact.getFirstName().equalsIgnoreCase(firstName)) {
                System.out.println("Contact found. Enter updated details:");
                contact.setLastName(readRequiredInput("Enter last name: "));
                contact.setAddress(readRequiredInput("Enter address: "));
                contact.setCity(readRequiredInput("Enter city: "));
                contact.setState(readRequiredInput("Enter state: "));
                contact.setZip(readRequiredInput("Enter zip: "));
                contact.setPhoneNumber(readValidPhoneNumber("Enter phone number: "));
                contact.setEmail(readValidEmail("Enter email: "));
                System.out.println("Contact Updated Successfully");
                System.out.println(contact);
                return;
            }
        }

        System.out.println("Contact Not Found");
    }

    public void deleteContact() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts available to delete.");
            return;
        }

        System.out.print("Enter first name of contact to delete: ");
        String firstName = scanner.nextLine().trim();

        for (int i = 0; i < contacts.size(); i++) {
            Contact contact = contacts.get(i);
            if (contact.getFirstName().equalsIgnoreCase(firstName)) {
                contacts.remove(i);
                System.out.println("Contact Deleted Successfully");
                return;
            }
        }

        System.out.println("Contact Not Found");
    }

    public void displayContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts available to display.");
            return;
        }

        System.out.println("Contacts in Address Book:");
        for (Contact contact : contacts) {
            System.out.println(contact);
        }
    }

    public void searchContact() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts available to search.");
            return;
        }

        System.out.print("Enter first name of contact to search: ");
        String firstName = scanner.nextLine().trim();

        for (Contact contact : contacts) {
            if (contact.getFirstName().equalsIgnoreCase(firstName)) {
                System.out.println("Contact found:");
                System.out.println(contact);
                return;
            }
        }

        System.out.println("Contact Not Found");
    }

    private String readRequiredInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            String value = scanner.nextLine().trim();
            if (!value.isEmpty()) {
                return value;
            }
            System.out.println("Input cannot be empty. Please try again.");
        }
    }

    private String readValidPhoneNumber(String prompt) {
        while (true) {
            System.out.print(prompt);
            String phoneNumber = scanner.nextLine().trim();
            if (phoneNumber.matches("\\d{10}")) {
                return phoneNumber;
            }
            System.out.println("Invalid phone number. Please enter exactly 10 digits.");
        }
    }

    private String readValidEmail(String prompt) {
        while (true) {
            System.out.print(prompt);
            String email = scanner.nextLine().trim();
            if (email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
                return email;
            }
            System.out.println("Invalid email format. Please enter a valid email address.");
        }
    }
}
