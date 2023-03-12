package Contact;

public class ContactInteratorClass {
    private static final int DEFAULT_INDEX = 0;
    private ContactClass[] contacts;
    private int size, nextIndex;

    public ContactInteratorClass(ContactClass[] contacts, int size){
        setContacts(contacts);
        setSize(size);
        setNextIndex(DEFAULT_INDEX);
    }

    public boolean hasNext(){
        return getNextIndex() < getSize();
    }

    public ContactClass next(){
        return getContacts()[nextIndex++];
    }

    public ContactClass[] getContacts() {
        return contacts;
    }

    public void setContacts(ContactClass[] contacts) {
        this.contacts = contacts;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getNextIndex() {
        return nextIndex;
    }

    public void setNextIndex(int nextIndex) {
        this.nextIndex = nextIndex;
    }
}
