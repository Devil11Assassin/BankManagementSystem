package banksystem.person;

import java.util.ArrayList;

public class Client extends Person {
    private int clientAccountID;
    private String accountState;
    public float balance;
    public static int clientCount;
    private final boolean ADMIN_ACCESS = false;

    public Client(String fName, String lName, double pNumber, String address,
                  int clientAccountId, String accountState, float balance) {
        super(fName, lName, pNumber, address);
        this.clientAccountID = clientAccountId;
        this.accountState = accountState;
        this.balance = balance;
        clientCount++;
    }

    public int getClientAccountID() {
        return clientAccountID;
    }

    public void EditpersonalInfo() {

    }

    public void displayAccountDetails(Client client) {
        System.out.println(client.clientAccountID + client.balance + client.accountState);
    }

    public void depositTransaction(float DepositAmount, float AccountBalance) {
        AccountBalance += DepositAmount;
    }

    public void withdrawalTransaction(float withdrawalAmount, float AccountBalance) {
        if (AccountBalance >= withdrawalAmount)
            AccountBalance -= withdrawalAmount;
        else
            System.out.println("no enough money!");
    }

    public void transferTransaction(float TransferAmount, float AccountBalance,
                                    int AccountID) {
        Employee employee;
        if (employee.searchClientAccount(AccountID) != null) {
            if (AccountBalance >= TransferAmount) {
                //client amount not changed
                //every transaction must be implemented in file
                AccountBalance -= TransferAmount;
            } else
                System.out.println("Not enough money!");
        }
    }

    public void showTransactionHistory() {
        //call file of transaction
        //sout the result
    }
}