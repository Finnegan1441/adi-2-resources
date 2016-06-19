import java.util.ArrayList;

/**
 * Created by patrickcummins on 6/19/16.
 */

public class PhoneBook {
    ArrayList<Contact> mContacts;
    String phoneBookType;

    public PhoneBook() {
        this.mContacts = new ArrayList<Contact>();
        phoneBookType = "phoneBook";
    }

    public void setPhoneBookType(String phoneBookType) {
        this.phoneBookType = phoneBookType;
    }

    public String getPhoneBookType() {

        return phoneBookType;
    }

    public PhoneBook(ArrayList<Contact> mContacts) {
        this.mContacts = mContacts;
    }

    public void setmContacts(ArrayList<Contact> mContacts) {
        this.mContacts = mContacts;
    }

    public ArrayList<Contact> getmContacts() {

        return mContacts;
    }

    public  void addContact(Contact newContact){
        mContacts.add(newContact);
    }
    public void removeContact(Contact removeContact){
      mContacts.remove(removeContact);
    }

}
