package model;

public class User {
    String useName;
    String mobileNumber;

    public User(String useName, String mobileNumber) {
        this.useName = useName;
        this.mobileNumber = mobileNumber;
    }

    public String getUseName() {
        return useName;
    }

    public void setUseName(String useName) {
        this.useName = useName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
}
