import java.util.ArrayList;

/**
 * Created by patrickcummins on 6/19/16.
 */
public class AndroidPhoneBook extends PhoneBook {
    float mAndroidVersion;

    public AndroidPhoneBook(ArrayList<Contact> mContacts, float AndroidVersion) {
        super(mContacts);
        this.mAndroidVersion = AndroidVersion;
        phoneBookType = "Android";
    }
    public AndroidPhoneBook( float AndroidVersion) {
        super();
        this.mAndroidVersion = AndroidVersion;
        phoneBookType = "Android";
    }

    public float getmAndroidVersion() {
        return mAndroidVersion;
    }

    public void setmAndroidVersion(float mAndroidVersion) {
        this.mAndroidVersion = mAndroidVersion;
    }
    public boolean isVersionSupported(){
        if (mAndroidVersion>4.0){
            return true;
        }else {
            return false;
        }

    }
}
