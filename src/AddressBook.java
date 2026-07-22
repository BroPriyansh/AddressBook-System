import java.util.Scanner;

public class AddressBook {
    private final Scanner scanner;

    public AddressBook() {
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            System.out.println("\n1. Add Contact");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    addContact();
                    break;
                case "2":
                    System.out.println("Exiting Address Book Program");
                    return;
                default:
                    System.out.println("Invalid choice. Please enter 1 or 2.");
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
        System.out.println("Contact Added Successfully");
        System.out.println(contact);
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
