import java.util.*;

public class Main {
    private static ContactManager manager = new ContactManager();
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("Welcome to Contact Manager!");
        System.out.println("==========================");
        
        while (true) {
            showMenu();
            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // consume newline
                
                switch (choice) {
                    case 1:
                        addPersonalContact();
                        break;
                    case 2:
                        addBusinessContact();
                        break;
                    case 3:
                        viewAllContacts();
                        break;
                    case 4:
                        searchByName();
                        break;
                    case 5:
                        removeContact();
                        break;
                    case 6:
                        viewPersonalContacts();
                        break;
                    case 7:
                        viewBusinessContacts();
                        break;
                    case 8:
                        System.out.println("Thank you for using Contact Manager!");
                        return;
                    default:
                        System.out.println("Invalid option! Please choose 1-8.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.nextLine(); // clear invalid input
            }
            
            System.out.println("\nPress Enter to continue...");
            scanner.nextLine();
        }
    }
    
    private static void showMenu() {
        System.out.println("\n=== Contact Manager ===");
        System.out.println("1. Add Personal Contact");
        System.out.println("2. Add Business Contact");
        System.out.println("3. View All Contacts");
        System.out.println("4. Search by Name");
        System.out.println("5. Remove Contact");
        System.out.println("6. View Personal Contacts Only");
        System.out.println("7. View Business Contacts Only");
        System.out.println("8. Exit");
        System.out.print("Choose option (1-8): ");
    }
    
    private static void addPersonalContact() {
        try {
            System.out.print("Enter name: ");
            String name = scanner.nextLine();
            
            System.out.print("Enter phone number (10 digits): ");
            String phone = scanner.nextLine();
            
            System.out.print("Enter email: ");
            String email = scanner.nextLine();
            
            System.out.print("Enter birthday (MM/DD/YYYY): ");
            String birthday = scanner.nextLine();
            
            PersonalContact contact = new PersonalContact(name, phone, email, birthday);
            int id = manager.addContact(contact);
            
            System.out.println("Personal contact added successfully! ID: " + id);
            
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    private static void addBusinessContact() {
        try {
            System.out.print("Enter name: ");
            String name = scanner.nextLine();
            
            System.out.print("Enter phone number (10 digits): ");
            String phone = scanner.nextLine();
            
            System.out.print("Enter email: ");
            String email = scanner.nextLine();
            
            System.out.print("Enter company: ");
            String company = scanner.nextLine();
            
            BusinessContact contact = new BusinessContact(name, phone, email, company);
            int id = manager.addContact(contact);
            
            System.out.println("Business contact added successfully! ID: " + id);
            
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    private static void viewAllContacts() {
        List<Contact> contacts = manager.getAllContacts();
        
        if (contacts.isEmpty()) {
            System.out.println("No contacts found.");
            return;
        }
        
        System.out.println("\n=== All Contacts ===");
        displayContacts(contacts);
    }
    
    private static void searchByName() {
        System.out.print("Enter name to search: ");
        String name = scanner.nextLine();
        
        List<Contact> results = manager.searchByName(name);
        
        if (results.isEmpty()) {
            System.out.println("No matches found for: " + name);
            return;
        }
        
        System.out.println("\n=== Search Results ===");
        displayContacts(results);
    }
    
    private static void removeContact() {
        System.out.print("Enter phone number to remove: ");
        String phone = scanner.nextLine();
        
        boolean removed = manager.removeContact(phone);
        
        if (removed) {
            System.out.println("Contact removed successfully!");
        } else {
            System.out.println("Contact not found with phone: " + phone);
        }
    }
    
    private static void viewPersonalContacts() {
        List<PersonalContact> contacts = manager.getPersonalContacts();
        
        if (contacts.isEmpty()) {
            System.out.println("No personal contacts found.");
            return;
        }
        
        System.out.println("\n=== Personal Contacts ===");
        displayContacts(new ArrayList<>(contacts));
    }
    
    private static void viewBusinessContacts() {
        List<BusinessContact> contacts = manager.getBusinessContacts();
        
        if (contacts.isEmpty()) {
            System.out.println("No business contacts found.");
            return;
        }
        
        System.out.println("\n=== Business Contacts ===");
        displayContacts(new ArrayList<>(contacts));
    }
    
    private static void displayContacts(List<Contact> contacts) {
        for (int i = 0; i < contacts.size(); i++) {
            System.out.println((i + 1) + ". " + contacts.get(i));
        }
        System.out.println("\nTotal contacts: " + contacts.size());
    }
}