package banksystem.options;

import java.util.Scanner;
import banksystem.Main;
import banksystem.account.Client;

public class OptionsClient {
    //Account Details Methods
    public static void editPersonalInfo(Client client) {
        char redo = 'Y';
        do {
            System.out.print("\n1.Firstname" +
                             "\n2.Lastname" +
                             "\n3.Phone number" +
                             "\n4.Address" +
                             "\nSelect: ");

            Scanner input = new Scanner(System.in);
            int selection = Main.inputInt(input);

            if (selection == 1)
            {
                System.out.print("Enter your new firstname: ");
                client.firstName = input.nextLine();
            }
            else if (selection == 2)
            {
                System.out.print("Enter your new lastname: ");
                client.lastName = input.nextLine();
            }
            else if (selection == 3)
            {
                System.out.print("Enter your new phone number: ");
                client.setPhoneNumber(Main.inputLong(input));
            }
            else if (selection == 4)
            {
                System.out.print("Enter your new address: ");
                client.setAddress(input.nextLine());
            }
            else
            {
                System.out.println("Error: Invalid selection!");
                continue;
            }

            System.out.println("Do you wish to edit another attribute? (y/n)");
            redo = input.next().charAt(0);
        } while (redo == 'y' || redo == 'Y');
    }

    public static void displayAccountDetails(Client client) {
        client.displayAccountDetails();
    }

    public static void displayAccountIdentification(Client client) {
        client.displayAccountIdentification();
    }

    //Transaction Methods
    public static void depositMenu(Client client) {
        System.out.print("\nDeposit amount: ");
        Scanner input = new Scanner(System.in);
        float depositAmount;

        do {
            depositAmount = Main.inputFloat(input);

            if (depositAmount > 0)
                break;
            else
                System.out.print("\nERROR! Enter a valid value: ");
        } while (true);

        client.deposit(depositAmount);
        System.out.println("Deposited: " + depositAmount + "\nNew balance: " + client.balance);
    }

    public static void withdrawalMenu(Client client) {
        System.out.print("\nWithdrawal amount: ");
        Scanner input = new Scanner(System.in);
        float withdrawalAmount;

        do {
            withdrawalAmount = Main.inputFloat(input);

            if (withdrawalAmount > 0)
                break;
            else
                System.out.print("\nERROR! Enter a valid value: ");
        } while (true);

        if (client.balance >= withdrawalAmount)
        {
            client.withdraw(withdrawalAmount);
            System.out.println("Withdrew: " + withdrawalAmount + "\nNew balance: " + client.balance);
        }
        else
            System.out.println("ERROR: Insufficient funds!");
    }

    public static void transferMenu(Client client) {
        Scanner input = new Scanner(System.in);
        System.out.print("\nTransferal amount: ");
        float transferAmount;

        do {
            transferAmount = Main.inputFloat(input);

            if (transferAmount > 0)
                break;
            else
                System.out.print("\nERROR! Enter a valid value: ");
        } while (true);

        if (client.balance >= transferAmount) {
            OptionsEmployee tempOptions = new OptionsEmployee();
            Client transferToClient = tempOptions.searchClientAccount();

            if (transferToClient != null) {
                client.transfer(transferAmount, transferToClient);
                System.out.println("Transferred: " + transferAmount + "\nNew balance: " + client.balance);
            } else
                System.out.println("\nERROR: Client not found!");
        } else
            System.out.println("\nERROR: Insufficient funds!");
    }

}
