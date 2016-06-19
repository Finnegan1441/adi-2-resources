import java.util.ArrayList;

/**
 * Created by patrickcummins on 6/19/16.
 */
public class Main {

    public static void main (String [] args){
        ArrayList<Contact> contactsList = new ArrayList<>();

        Contact patrick = new Contact("Patrick", "510-289-7776");
        Contact home = new Contact("Home", "510-594-8021");
        Contact dad = new Contact("Dad", "510-282-2347");

        contactsList.add(patrick);
        contactsList.add(home);
        contactsList.add(dad);
        PhoneBook iPhoneBook = new PhoneBook(contactsList);
        PhoneBook androidBook = new PhoneBook();
        androidBook=iPhoneBook;

        for (int i = 0; i < iPhoneBook.getmContacts().size() ; i++) {
            iPhoneBook.getmContacts().remove(i);

        }

        PhoneBook iPhoneBook2 = new PhoneBook(contactsList);
        AndroidPhoneBook androidBook2 = new AndroidPhoneBook(2.0f);

        if (androidBook2.isVersionSupported()){

        }else {
            System.out.println("Version Not Supported");
        }

        for (int i = 0; i < iPhoneBook2.getmContacts().size(); i++) {
            androidBook2.addContact(iPhoneBook2.getmContacts().get(i));

        }



    }
}
