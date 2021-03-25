import java.util.ArrayList;

public class MobilePhone {
    private String myNumber;
    private ArrayList <Contact> myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<Contact>();
    }
    public boolean addNewContact(Contact contact){
        if(findContact(contact.getName()) >=0){
            return false;
        }
        this.myContacts.add(contact);
        return true;
    }
    public boolean updateContact(Contact oldContact, Contact newContact){// two records being passed in to compare.
        int positionOld = findContact(oldContact);
        if(positionOld <0){
            System.out.println(oldContact.getName() + "Not Found!");
            return false;
        }else{
            if(findContact(newContact.getName()) !=-1){
                System.out.println("Contact with name " + newContact.getName() + " already exist, update not successful. ");
                return false;
            }
        }
        this.myContacts.set(positionOld, newContact);
        System.out.println(oldContact.getName() + " was replaced by " + newContact.getName());
        return true;
    }
    public boolean removeContact(Contact contact){
        int position = findContact(contact);
        if(position <0){
            return false;
        }
        this.myContacts.remove(position);
        return true;
    }
    //searches for a Contact Record
    private int findContact(Contact contact){
        if(myContacts.contains(contact)) {
            return this.myContacts.indexOf(contact);
        }
        return -1;
    }
    private int findContact(String name ){ // searches for Only a name
        for(int i=0; i< myContacts.size(); i+=1) {
            Contact contact = this.myContacts.get(i);
            if(contact.getName().equals(name)){
                return i;
            }
        }
        return -1;
    }
    public Contact queryContact(String name){
        int position = findContact(name);
        if(position >=0){
            return this.myContacts.get(position);
        }
        return null;
    }
    public void printContacts(){
        System.out.println("Contact List:");
        for(int i=0; i<this.myContacts.size(); i+=1){
            System.out.println((i+1)+ ". " + this.myContacts.get(i).getName()
                                    + " -> " + this.myContacts.get(i).getPhoneNumber());
        }
    }
}
