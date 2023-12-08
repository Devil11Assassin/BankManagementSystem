package banksystem.account;

import java.util.ArrayList;
import java.util.Scanner;

public class Client extends Account {
    private int clientAccountID;
    private boolean accountStateIsActive;
    public float balance;
    public static int clientCount;

    public Client() {
        super();
    }

    public Client(String fName, String lName, long pNumber, String address,
                  String username, String password,
                  int clientAccountID, boolean accountState, float balance) {
        super(fName, lName, pNumber, address, username, password);
        this.clientAccountID = clientAccountID;
        this.accountStateIsActive = accountState;
        this.balance = balance;
        clientCount++;
    }

    public int getClientAccountID() {
        return clientAccountID;
    }

    public boolean getAccountStateIsActive() { return accountStateIsActive; }

    public void setAccountState(boolean accountStateIsActive) {
        this.accountStateIsActive = accountStateIsActive;
    }

    public void editPersonalInfo(Client client) {
        char redo = 'Y';
        do {
            System.out.println("""
                    1.Firstname
                    2.Lastname
                    3.Phone number
                    4.Address
                    Selection:\s""");

            Scanner input = new Scanner(System.in);
            int selection = input.nextInt();

            if (selection == 1) {
                System.out.println("Enter your new firstname: ");
                client.firstName = input.nextLine();
            } else if (selection == 2) {
                System.out.println("Enter your new lastname: ");
                client.lastName = input.nextLine();
            } else if (selection == 3) {
                System.out.println("Enter your new phone number: ");
                client.phoneNumber = input.nextLong();
            } else if (selection == 4) {
                System.out.println("Enter your new address: ");
                client.address = input.nextLine();
            } else {
                System.out.println("Error: Invalid selection!");
                continue;
            }
            System.out.println("Do you wish to edit another attribute? (y/n)");
            redo = input.next().charAt(0);
        } while (redo == 'y' || redo == 'Y');
    }

    public void displayAccountDetails() {
        System.out.println("\nName: " + this.firstName + " " + this.lastName + "\n" +
                           "Phone number: " + this.phoneNumber + "\n" +
                           "Address: " + this.address + "\n\n" +
                           "Username: " + this.getUsername() + "\n" +
                           "Password: " + this.getPassword() + "\n" +
                           "ID: " + this.getClientAccountID() + "\n" +
                           "Account state: " + this.getAccountStateIsActive() + "\n" +
                           "Balance: " + this.balance + "\n");
    }

    public void depositTransaction(Client client) {
        System.out.println("Enter the amount you want to deposit: ");
        Scanner input = new Scanner(System.in);
        float DepositAmount = input.nextFloat();
        client.balance += DepositAmount;

        System.out.println("Deposited: " + DepositAmount + "\nNew balance: " + client.balance + "\n");
    }

    public void withdrawalTransaction(Client client) {
        System.out.println("Enter the amount you want to withdraw: ");
        Scanner input = new Scanner(System.in);
        float withdrawalAmount = input.nextFloat();

        if (client.balance >= withdrawalAmount) {
            client.balance -= withdrawalAmount;
            System.out.println("Withdrew: " + withdrawalAmount + "\nNew balance: " + client.balance + "\n");
        } else
            System.out.println("Error: Insufficient funds!");
    }

    public void transferTransaction(Client client, ArrayList<Client> clients) {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter the account's ID that you wish to transfer funds to: ");
        int clientID = input.nextInt();

        System.out.println("Enter the amount you wish to transfer: ");
        float transferAmount = input.nextFloat();

        Employee employee = new Employee();
        Client transferToClient = employee.searchClientAccount(clients);
        if (transferToClient != null) {
            if (client.balance >= transferAmount) {
                client.balance -= transferAmount;
                transferToClient.balance += transferAmount;
            } else
                System.out.println("Insufficient funds!");
            // if insufficient ask for permission to call the deposit function
        } else
            System.out.println("Error: Client not found!");
    }

    public void showTransactionHistory(Client client) {
        // IDEAS
        // create a transaction history class contains date&time, balance diff
        //client has a dynamic array of transaction history
        //call file of transaction
        //sout the result
    }
}