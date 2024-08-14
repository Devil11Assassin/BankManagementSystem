package banksystem.account;

import banksystem.Main;

public class Client extends Account {
    //Fields
    private int accountID;
    private boolean accountStateIsActive;
    public float balance;
    public boolean isSavingsAccount;

    //Constructors
    public Client() {
        super();
    }
    public Client(String fName, String lName, long pNumber, String address,
                  String username, String password, int accountID, boolean accountState,
                  float balance, boolean isSavingsAccount) {
        super(fName, lName, pNumber, address, username, password);
        this.accountID = accountID;
        this.accountStateIsActive = accountState;
        this.balance = balance;
        this.isSavingsAccount = isSavingsAccount;
    }

    //Getters
    public int getAccountID() {
        return accountID;
    }
    public boolean getAccountStateIsActive() {
        return accountStateIsActive;
    }

    //Setters
    public void setAccountID(int id) {
        this.accountID = id;
    }
    public void setAccountState(boolean accountStateIsActive) {
        this.accountStateIsActive = accountStateIsActive;
    }

    //Account Details Methods
    public void displayAccountDetails() {
        System.out.println("\nName: " + firstName + " " + lastName +
                           "\nPhone number: " + phoneNumber +
                           "\nAddress: " + address + "\n" +
                           "\nUsername: " + getUsername() +
                           "\nPassword: " + getPassword() +
                           "\nID: " + getAccountID() +
                           "\nAccount state: " + getAccountStateIsActive() +
                           "\nBalance: " + balance +
                           "\nSavings Account: " + isSavingsAccount + "\n");
    }
    public void displayAccountIdentification() {
        System.out.println("\nUsername: " + getUsername() +
                           "\nPassword: " + getPassword() +
                           "\nID: " + getAccountID() +
                           "\nAccount state: " + getAccountStateIsActive() +
                           "\nSavings Account: " + isSavingsAccount + "\n");
    }

    //Transaction Methods
    public void deposit(float deposition) {

        this.balance += deposition;
        Main.previousTransactions.add(new PreviousTransaction(accountID, this.balance,
                this.balance - deposition, PreviousTransaction.Type.DEPOSIT));
    }

    public void withdraw(float withdrawal) {

        this.balance -= withdrawal;
        Main.previousTransactions.add(new PreviousTransaction(accountID, this.balance,
                this.balance + withdrawal, PreviousTransaction.Type.WITHDRAWAL));
    }

    public void transfer(float transferal, Client recipient) {

        this.balance -= transferal;
        recipient.balance += transferal;

        Main.previousTransactions.add(new PreviousTransaction(accountID, this.balance,
                this.balance + transferal, PreviousTransaction.Type.TRANSFER_WITHDRAWAL));
        Main.previousTransactions.add(new PreviousTransaction(recipient.accountID, recipient.balance,
                recipient.balance - transferal, PreviousTransaction.Type.TRANSFER_DEPOSIT));
    }
}