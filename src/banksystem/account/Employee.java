package banksystem.account;

import banksystem.Main;

public class Employee extends Account {
    //Fields
    protected int accountID;
    public String uniGraduated;
    public int yearOfGraduation;
    protected char[] grade = new char[2];
    protected char position;
    private boolean adminAccess;

    //Constructors
    public Employee() {
        super();
    }

    public Employee(String fName, String lName, long pNumber, String address,
                    String username, String password, int accountID,
                    String uniGraduated, int yearOfGraduation, String grade, char position, boolean adminAccess) {

        super(fName, lName, pNumber, address, username, password);
        this.accountID = accountID;
        this.uniGraduated = uniGraduated;
        this.yearOfGraduation = yearOfGraduation;
        if (grade.charAt(0) != '+' && grade.charAt(0) != '-') {
            this.grade[0] = grade.charAt(0);
            this.grade[1] = '';
        } else {
            this.grade[0] = grade.charAt(0);
            this.grade[1] = grade.charAt(1);
        }
        this.position = position;
        this.adminAccess = adminAccess;
    }


    //Setters
    public void setAccountID(int employeeAccountID) {
        this.accountID = employeeAccountID;
    }
    public void setGrade(String grade) {
        if (grade.charAt(0) != '+' && grade.charAt(0) != '-') {
            this.grade[0] = grade.charAt(0);
            this.grade[1] = '';
        } else {
            this.grade[0] = grade.charAt(0);
            this.grade[1] = grade.charAt(1);
        }
    }
    public void setPosition(char position) {
        this.position = position;
    }
    public void setAdminAccess(boolean adminAccess) {
        this.adminAccess = adminAccess;
    }

    //Getters
    public int getAccountID() {
        return accountID;
    }
    public char[] getGrade() {
        return grade;
    }
    public char getPosition() {
        return position;
    }
    public boolean getAdminAccess() {
        return adminAccess;
    }

    //Methods
    public void displayInformation() {
        System.out.println("\nName: " + firstName + " " + lastName +
                           "\nPhone number: " + phoneNumber +
                           "\nAddress: " + address + "\n" +
                           "\nGraduated from " + uniGraduated + ", " + yearOfGraduation + " with " + grade[0] + grade[1] + " grade." +
                           "\nUsername: " + getUsername() +
                           "\nPassword: " + getPassword() +
                           "\nID: " + accountID +
                           "\nPosition: " + position +
                           "\nAdmin access: " + adminAccess + "\n");
    }
    public void displayIdentification() {
        System.out.println("\nUsername: " + getUsername() +
                           "\nPassword: " + getPassword() +
                           "\nID: " + accountID +
                           "\nPosition: " + position +
                           "\nAdmin access: " + adminAccess + "\n");
    }

    //Client Account Methods
    //Creation
    public void createClientAccount(String firstName, String lastName, long phoneNumber, String address,
                                    String username, String password, int id, boolean isSavingsAccount) {
        Main.clients.add(new Client(firstName, lastName, phoneNumber, address, username,
                password, id, true, 0, isSavingsAccount));
    }

    //Modification
    public void editClientFirstName(Client client, String firstName) {
        client.firstName = firstName;
    }
    public void editClientLastName(Client client, String lastName) {
        client.lastName = lastName;
    }
    public void editClientPhoneNumber(Client client, int phoneNumber) {
        client.phoneNumber = phoneNumber;
    }
    public void editClientAddress(Client client, String address) {
        client.address = address;
    }

    public void editClientUsername(Client client, String username) {
        client.username = username;
    }
    public void editClientPassword(Client client, String password) {
        client.setPassword(password);
    }

    public void editClientAccountState(Client client, boolean accountState) {
        client.setAccountState(accountState);
    }
    public void editClientBalance(Client client, float balance) {
        client.balance = balance;
    }
    public void editClientIsSavings(Client client, boolean isSavingsAccount) {
        client.isSavingsAccount = isSavingsAccount;
    }

    //Deletion
    public void deleteClientAccount(Client client) {
        Main.clients.remove(client);
    }

    //Display Information
    public void displayClientInformation(Client client) {
       client.displayAccountDetails();
    }

    //Search
    public Client searchClientAccount(String username) {
        for (Client client : Main.clients) {
            if (client.getUsername().equals(username))
                return client;
        }
        return null;
    }

    public Client searchClientAccount(int id) {
        for (Client client : Main.clients) {
            if (client.getAccountID() == id)
                return client;
        }
        return null;
    }
}