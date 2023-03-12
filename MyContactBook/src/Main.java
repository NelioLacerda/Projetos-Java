import Contact.ContactBookClass;
import Contact.ContactInteratorClass;

import java.util.Scanner;

public class Main {
    //constants
    private static final String ADD_CONTACT = "AC";
    private static final String LIST_CONTACT = "LC";
    private static final String GET_PHONE = "GP";
    private static final String GET_EMAIL = "GE";
    private static final String SET_PHONE = "SP";
    private static final String SET_EMAIL = "SE";
    private static final String REMOVE_CONTACT = "RC";
    private static final String GET_NAME = "GN";
    private static final String EXIST_PHONE = "EP";
    private static final String EXIT = "Q";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ContactBookClass cBook = new ContactBookClass();
        executeProgram(sc, cBook);
        sc.close();
    }

    private static void executeProgram(Scanner sc, ContactBookClass cBook){
        String cmd;
        boolean has_finish = false;
        do{
            cmd = sc.nextLine();
            switch (cmd){
                case ADD_CONTACT -> addContactOption(sc, cBook);
                case LIST_CONTACT -> listContactOption(cBook);
                case GET_PHONE -> getPhoneOption(sc, cBook);
                case GET_EMAIL-> getEmailOption(sc, cBook);
                case SET_PHONE -> setPhoneOption(sc,cBook);
                case SET_EMAIL -> setEmailOption(sc, cBook);
                case REMOVE_CONTACT -> removeContactOption(sc, cBook);
                case GET_NAME -> getNameOption(sc, cBook);
                case EXIST_PHONE -> existPhoneOption(cBook);
                case EXIT -> has_finish = exitOption();
                default -> defaultOption();
            }
        }while (!has_finish);
    }
    private static void addContactOption(Scanner sc, ContactBookClass cBook){
        String name = sc.nextLine();
        int phoneNumber = sc.nextInt();
        String email = sc.next();
        sc.nextLine();
        if (!cBook.isAnExistentNumber(name)) {
            cBook.addContact(name, email, phoneNumber);
            System.out.println("Contact added.");
        }else{
            System.out.println("Contact already exists.");
        }
    }

    private static void listContactOption(ContactBookClass cBook) {
        if (cBook.hasContacts()) {
            ContactInteratorClass iterator = cBook.interator();
            while (iterator.hasNext()){
                System.out.println(iterator.next().toString());
            }
        }else {
            System.out.println("Contact book empty.");
        }
    }

    private static void getPhoneOption(Scanner sc, ContactBookClass cBook){
        String name = sc.nextLine();
        if (cBook.isAnExistentNumber(name)){
            System.out.println(cBook.searchNumber(name));
        }else{
            System.out.println("Contact does not exist.");
        }
    }
    private static void getEmailOption(Scanner sc, ContactBookClass cBook){
        String name = sc.nextLine();
        if(cBook.isAnExistentNumber(name)){
            System.out.println(cBook.searchEmail(name));
        }else{
            System.out.println("Contact does not exist.");
        }
    }
    private static void setPhoneOption(Scanner sc, ContactBookClass cBook){
        String name = sc.nextLine();
        int newPhoneNumber = sc.nextInt();
        if(cBook.isAnExistentNumber(name)){
            cBook.updateContactNumber(name, newPhoneNumber);
            System.out.println("Contact updated.");
        }else{
            System.out.println("Contact does not exist.");
        }
    }
    private static void setEmailOption(Scanner sc, ContactBookClass cBook){
        String name = sc.nextLine();
        String newEmail = sc.nextLine();
        if(cBook.isAnExistentNumber(name)){
            cBook.updateContactEmail(name, newEmail);
            System.out.println("Contact updated.");
        }else{
            System.out.println("Contact does not exist.");
        }
    }
    private static void removeContactOption(Scanner sc, ContactBookClass cBook){
        String name = sc.nextLine();
        if(cBook.isAnExistentNumber(name)){
            cBook.removeContact(name);
            System.out.println("Contact removed.");
        }else{
            System.out.println("Contact does not exist.");
        }
    }
    private static void getNameOption(Scanner sc, ContactBookClass cBook){
        int phoneNumber = sc.nextInt();
        sc.nextLine();
        if (cBook.isAnExistentPhoneNumber(phoneNumber)){
            System.out.println(cBook.searchContact(phoneNumber));
        }else {
            System.out.println("Phone number does not exist.");
        }
    }
    private static void existPhoneOption(ContactBookClass cBook){
        if (cBook.existRepeats()){
            System.out.println("There are contacts that share phone numbers.");
        }else{
            System.out.println("All contacts have different phone numbers.");
        }
    }

    private static boolean exitOption(){
        System.out.println("Goodbye!");
        return true;
    }
    private static void defaultOption(){
        System.out.println("Unknown command");
    }
}
