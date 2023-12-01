package banksystem.person;

public class Person {
    public String firstName;
    public String lastName;
    protected double phoneNumber;
    protected String address;

    public Person(String fName, String lName, double pNumber, String address) {
        firstName = fName;
        lastName = lName;
        phoneNumber = pNumber;
        this.address = address;
    }
}