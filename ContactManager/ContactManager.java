import java.util.*;

public class ContactManager {
    private List<Contact> contacts;
    private static int nextId = 1;

    public ContactManager() {
        this.contacts = new ArrayList<>();
    }

    public int addContact(Contact contact) {
        if (contact == null) {
            throw new IllegalArgumentException("Contact cannot be null");
        }
        
        // Check for duplicate phone number
        if (findContact(contact.getPhoneNumber()) != null) {
            throw new IllegalArgumentException("Contact with this phone number already exists");
        }
        
        contacts.add(contact);
        return nextId++;
    }

    public boolean removeContact(String phoneNumber) {
        Contact contact = findContact(phoneNumber);
        if (contact != null) {
            contacts.remove(contact);
            return true;
        }
        return false;
    }

    public Contact findContact(String phoneNumber) {
        for (Contact contact : contacts) {
            if (contact.getPhoneNumber().equals(phoneNumber)) {
                return contact;
            }
        }
        return null;
    }

    public List<Contact> getAllContacts() {
        return new ArrayList<>(contacts);
    }

    public int getContactCount() {
        return contacts.size();
    }

    public List<Contact> searchByName(String name) {
        List<Contact> result = new ArrayList<>();
        String searchName = name.toLowerCase();
        
        for (Contact contact : contacts) {
            if (contact.getName().toLowerCase().contains(searchName)) {
                result.add(contact);
            }
        }
        return result;
    }

    public List<PersonalContact> getPersonalContacts() {
        List<PersonalContact> result = new ArrayList<>();
        
        for (Contact contact : contacts) {
            if (contact instanceof PersonalContact) {
                result.add((PersonalContact) contact);
            }
        }
        return result;
    }

    public List<BusinessContact> getBusinessContacts() {
        List<BusinessContact> result = new ArrayList<>();
        
        for (Contact contact : contacts) {
            if (contact instanceof BusinessContact) {
                result.add((BusinessContact) contact);
            }
        }
        return result;
    }
}