package gg.patrickcummins.phonebook;

/**
 * Created by patrickcummins on 6/19/16.
 */

public class Contact {
    private String mName;
    private String mNumber;

    public Contact(String mName, String mNumber) {
        this.mName = mName;
        this.mNumber = mNumber;
    }

    public void setmNumber(String mNumber) {
        this.mNumber = mNumber;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmName() {

        return mName;
    }

    public String getmNumber() {
        return mNumber;
    }
}
