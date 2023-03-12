package Contact;

import Interfaces.ContactBookInterface;

public class ContactBookClass implements ContactBookInterface {
    private static final int DEFAULT_VALUE = 10, DEFAULT_NUM_OF_CONTACTS = 0;
    private ContactClass[] contacts;
    private int numOfContacts;
    public ContactBookClass(){
        contacts = new ContactClass[DEFAULT_VALUE];
        setNumOfContacts(DEFAULT_NUM_OF_CONTACTS);
    }


    @Override
    public void addContact(String name, String email, int number){
        if (getNumOfContacts() == contacts.length){
            grow();
        }
        contacts[numOfContacts++] = new ContactClass(name, email, number);
    }

    @Override
    public ContactInteratorClass interator(){
        return new ContactInteratorClass(contacts, numOfContacts);
    }

    @Override
    public int searchNumber(String name){
        int result = searchIndex(name);
        return contacts[result].getPhoneNumber();
    }

    @Override
    public String searchEmail(String name){
        int result = searchIndex(name);
        return contacts[result].getEmail();
    }

    @Override
    public void updateContactNumber(String name, int newPhoneNumber){
        int result = searchIndex(name);
        contacts[result].setPhoneNumber(newPhoneNumber);
    }

    @Override
    public void updateContactEmail(String name, String newEmail){
        int result = searchIndex(name);
        contacts[result].setEmail(newEmail);
    }

    @Override
    public void removeContact(String name){
        int result = searchIndex(name);
        for (int i = result; i + 1 < getNumOfContacts(); i++){
            contacts[i] = contacts[i + 1];
        }
        numOfContacts--;
    }

    @Override
    public String searchContact(int phoneNumber){
        return contacts[searchIndexByNumber(phoneNumber)].getName();
    }

    @Override
    public boolean existRepeats(){
        boolean foundRepeat = false;
        int i = 0;
        while (i<getNumOfContacts() && !foundRepeat){
            for (int p = i+1; p<getNumOfContacts(); p++){
                if (contacts[i].getPhoneNumber() == contacts[p].getPhoneNumber()) {
                    foundRepeat = true;
                    break;
                }
            }
            i++;
        }
        return foundRepeat;
    }

    private int searchIndexByNumber(int phoneNumber){
        int i = 0;
        int result = -1;
        boolean hasFound = false;
        while (i<getNumOfContacts() && !hasFound){
            if (contacts[i].getPhoneNumber() == phoneNumber){
                result = i;
                hasFound = true;
            }else{
                i++;
            }
        }
        return result;
    }

    @Override
    public boolean isAnExistentNumber(String name){
        int result = searchIndex(name);
        return result != -1;
    }

    @Override
    public boolean isAnExistentPhoneNumber(int phoneNumber){
        return searchIndexByNumber(phoneNumber) != -1;
    }
    private int searchIndex(String name){
        int i = 0;
        int result = -1;
        boolean hasFound = false;
        while (i<getNumOfContacts() && !hasFound){
            if (contacts[i].getName().equals(name)){
                hasFound = true;
                result = i;
            }else{
                i++;
            }
        }
        return result;
    }



    public boolean hasContacts(){
        return getNumOfContacts() > 0;
    }
    public int getNumOfContacts() {
        return numOfContacts;
    }

    public void setNumOfContacts(int numOfContacts) {
        this.numOfContacts = numOfContacts;
    }

    //private methods
    private void grow(){
        ContactClass[] tmp = new ContactClass[2*contacts.length];
        for (int i = 0; i<getNumOfContacts(); i++){
            tmp[i] = contacts[i];
        }
        contacts = tmp;
    }
}
