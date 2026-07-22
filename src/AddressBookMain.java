public class AddressBookMain {
    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program");

        Contact contact = new Contact(
                "Priyansh",
                "Sharma",
                "123 Main Street",
                "Delhi",
                "Delhi",
                "110001",
                "9876543210",
                "priyansh@example.com"
        );

        System.out.println(contact);
    }
}
