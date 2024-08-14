package banksystem.account;

import banksystem.Main;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;



public class PreviousTransaction implements Serializable {
    public enum Type {
        DEPOSIT,
        WITHDRAWAL,
        TRANSFER_DEPOSIT,
        TRANSFER_WITHDRAWAL,
        ALL,
    }

    public int clientID;
    public LocalDateTime dateAndTime;
    public float afterTransaction, beforeTransaction;
    public Type type;

    public PreviousTransaction() {}
    public PreviousTransaction(int clientID, float afterTransaction, float beforeTransaction, Type type) {
        this.clientID = clientID;
        this.dateAndTime = LocalDateTime.now();
        this.afterTransaction = afterTransaction;
        this.beforeTransaction = beforeTransaction;
        this.type = type;
    }

    public void selectTransactionHistory(Client client, ArrayList<PreviousTransaction> previousTransactions) {
        boolean performAnotherOperation = true;
        do {
            System.out.print("\nType of transaction to display:" +
                             "\n       1.Deposit" +
                             "\n       2.Withdrawal" +
                             "\n       3.Transfer (deposit)" +
                             "\n       4.Transfer (withdrawal)" +
                             "\n       5.All" +
                             "\nSelect: ");

            Scanner input = new Scanner(System.in);
            int selection;
            do {
                try {
                    selection = input.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.print("\nError: Invalid input!\n Enter a number: ");
                    input.nextLine();
                }
            } while (true);

            if (selection == 1)
                showTransactionHistory(client.getAccountID(), Type.DEPOSIT);
            else if (selection == 2)
                showTransactionHistory(client.getAccountID(), Type.WITHDRAWAL);
            else if (selection == 3)
                showTransactionHistory(client.getAccountID(), Type.TRANSFER_DEPOSIT);
            else if (selection == 4)
                showTransactionHistory(client.getAccountID(), Type.TRANSFER_WITHDRAWAL);
            else if (selection == 5)
                showTransactionHistory(client.getAccountID(), Type.ALL);
            else {
                System.out.println("Error: Invalid selection.");
                continue;
            }

            do {
                System.out.print("Do you wish to perform another operation in \"Display Transaction History\"? (y/n): ");
                char answer = input.next().charAt(0);
                if (answer == 'y' || answer == 'Y') {
                    break;
                } else if (answer == 'n' || answer == 'N') {
                    performAnotherOperation = false;
                    break;
                } else
                    System.out.println("Invalid input: Enter (y/n) only!");
            } while (true);

        } while (performAnotherOperation);
    }

    public static void showTransactionHistory(int ID, Type type) {
        boolean found = false;
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd, HH:mm:ss");

        for (PreviousTransaction previousTransaction : Main.previousTransactions) {
            if (type.equals(Type.ALL)) {
                if (ID == previousTransaction.clientID) {
                    found = true;
                    System.out.println("\nTransaction Date&Time: " + previousTransaction.dateAndTime.format(format) +
                                       "\nBalance before transaction: " + previousTransaction.beforeTransaction +
                                       "\nBalance after transaction: " + previousTransaction.afterTransaction +
                                       "\nTransaction type: " + previousTransaction.type);
                }
            } else {
                if (ID == previousTransaction.clientID && type.equals(previousTransaction.type)) {
                    found = true;
                    System.out.println("\nTransaction Date&Time: " + previousTransaction.dateAndTime.format(format) +
                                       "\nBalance before transaction: " + previousTransaction.beforeTransaction +
                                       "\nBalance after transaction: " + previousTransaction.afterTransaction);
                }
            }
        }
        if (!found)
            System.out.println("Client's transaction history is empty.");
    }
}