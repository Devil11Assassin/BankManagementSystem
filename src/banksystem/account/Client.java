package banksystem.account;

import java.util.ArrayList;
import java.util.Scanner;

public class Client extends Account {
    private int clientAccountID;
    private String accountState;
    public float balance;
    public static int clientCount;

    public Client() {
        super();
    }

    public Client(String fName, String lName, long pNumber, String address,
                  String username, String password,
                  int clientAccountID, String accountState, float balance) {
        super(fName, lName, pNumber, address, username, password);
        this.clientAccountID = clientAccountID;
        this.accountState = accountState;
        this.balance = balance;
        clientCount++;
    }

    public int getClientAccountID() {
        return clientAccountID;
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

    public void displayAccountDetails(Client client) {
        System.out.println(client.clientAccountID + client.balance + client.accountState);
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
        if (employee.searchClientAccount(clients, clientID) != null) {
            if (client.balance >= transferAmount) {
                client.balance -= transferAmount;
                employee.searchClientAccount(clients, clientID).balance += transferAmount;
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