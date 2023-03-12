package Interfaces;

import Contact.ContactInteratorClass;

public interface ContactBookInterface {
    void addContact(String name, String email, int number);
    ContactInteratorClass interator();
    int searchNumber(String name);
    String searchEmail(String name);
    void updateContactNumber(String name, int newPhoneNumber);
    void updateContactEmail(String name, String newEmail);
    void removeContact(String name);
    String searchContact(int phoneNumber);
    boolean existRepeats();
    boolean isAnExistentNumber(String name);
    boolean isAnExistentPhoneNumber(int phoneNumber);

}
