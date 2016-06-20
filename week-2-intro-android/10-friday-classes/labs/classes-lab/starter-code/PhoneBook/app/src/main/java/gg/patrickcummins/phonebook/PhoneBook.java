package gg.patrickcummins.phonebook;

import java.util.ArrayList;

/**
 * Created by patrickcummins on 6/19/16.
 */

public class PhoneBook {
    ArrayList<Contact> mContacts;

    public PhoneBook() {
        this.mContacts = new ArrayList<Contact>();
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

    public ArrayList<Contact> removeContact(String Name){
        if (mContacts.size()>0){
            for (int i = 0; i < ; i++) {


            }
        }
    }
}
