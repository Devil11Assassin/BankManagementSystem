package banksystem.account;

import java.io.Serializable;

public abstract class Account implements Serializable {
    //Fields
    public String firstName;
    public String lastName;
    protected long phoneNumber;
    protected String address;

    protected String username;
    private String password;

    //Constructors
    public Account(){}
    public Account(String fName, String lName, long pNumber, String address,
                   String username, String password) {
        firstName = fName;
        lastName = lName;
        phoneNumber = pNumber;
        this.address = address;
        this.username = username;
        this.password = password;
    }

    //Setters
    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public void setUsername(String username) {
            this.username = username;
    }
    public void setPassword(String password) {
            this.password = password;
    }

    //Getters
    public long getPhoneNumber() {
        return phoneNumber;
    }
    public String getAddress() {
        return address;
    }

    public String getUsername() {
        return username;
    }
    public String getPassword() {
            return password;
    }
}