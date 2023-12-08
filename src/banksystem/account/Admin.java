package banksystem.account;

import java.util.ArrayList;
import java.util.Scanner;

public class Admin extends Employee {

    public void employeeRegistration(ArrayList<Employee> employees) {

    }

    public void displayAccounts(ArrayList<Client> clients, ArrayList<Employee> employees) {
        Scanner input = new Scanner(System.in);

        System.out.println("Select which account type to display: (Client/Employee)");
        String answer = input.nextLine();

        if (answer.equals("client") || answer.equals("Client") || answer.equals("CLIENT")) {
            for (Client client : clients)
                client.displayAccountDetails();
        } else if (answer.equals("employee") || answer.equals("Employee") || answer.equals("EMPLOYEE")) {
            for (Employee employee : employees) {
                // employee[i].displayAccountDetails;
            }
        } else
            System.out.println("Cannot display accounts. Error: Invalid account type!");
    }

    public void displayTransactions(ArrayList<Client> clients) {
        //MERGE ALL FUNCTIONS BELOW INTO ONE FUNCTION
    }

    public void displayDepositTransactions(Client client) {
        if (client != null) {
            System.out.println("Your previous transactions of type 'Deposit':\n" +
                               "---------------------------------------------");
            //client.displayTransactions;  CHECK IF TYPE IS DEPOSIT
        }
    }

    public void displayWithdrawalTransactions(Client client) {
        if (client != null) {
            System.out.println("Your previous transactions of type 'Withdrawal':\n" +
                               "------------------------------------------------");
            //client.displayTransactions;  CHECK IF TYPE IS WITHDRAWAL
        }
    }

    public void displayTransferTransactions(Client client) {
        if (client != null) {
            System.out.println("Your previous transactions of type 'Transfer':\n" +
                               "----------------------------------------------");
            //client.displayTransactions;  CHECK IF TYPE IS TRANSFER
        }
    }
}