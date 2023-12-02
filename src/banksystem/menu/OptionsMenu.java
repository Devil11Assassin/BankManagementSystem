package banksystem.menu;

import banksystem.account.*;

import java.util.ArrayList;
import java.util.Scanner;

public class OptionsMenu {
    public void optionsClient(Client client, ArrayList<Client> clients) {
        boolean redo = true;
        do {
            System.out.print("\n1.Transaction\n" +
                               "2.Transaction History\n" +
                               "3.Account Details\n" +
                               "4.Edit Personal Information\n" +
                               "Select: ");


            Scanner input = new Scanner(System.in);
            int selection = input.nextInt();

            if (selection == 1) {
                System.out.println("\n1.Deposit\n" +
                                     "2.Withdraw\n" +
                                     "3.Transfer\n");
                /*if (clientSavings)
                    System.out.println("4.Loans\n");*/
                System.out.print("Select: ");
                selection = input.nextInt();

                if (selection == 1)
                    client.depositTransaction(client);
                else if (selection == 2)
                    client.withdrawalTransaction(client);
                else if (selection == 3)
                    client.transferTransaction(client, clients);
                //else if (selection == 4 && client.clientSavings == true){}
                //  call loan function
                else
                    System.out.println("Invalid selection!\n");
            }
            else if (selection == 2)
                client.showTransactionHistory(client);
            else if (selection == 3)
                client.displayAccountDetails(client);
            else if (selection == 4)
                client.editPersonalInfo(client);
            else
                System.out.println("Invalid selection!\n");

            System.out.println("Do you want to do another operation? (y/n)");
            Scanner answerInput = new Scanner(System.in);

            char answer = answerInput.next().charAt(0);
            if (answer != 'y' && answer != 'Y')
                redo = false;
        } while (redo);
    }

    public void optionsEmployee(Employee employee, ArrayList<Client> clients) {
        System.out.println("1.Client Accounts Management\n" +
                "2.Client Search\n" +
                "3.Account Details\n" +
                "4.Edit Personal Information\n");

    }

    public void optionsAdmin() {
        System.out.println("1.Transaction\n" +
                "2.Transaction History\n" +
                "3.Account Details\n" +
                "4.Edit Personal Information\n");
    }
}