package banksystem.menu;

import java.util.ArrayList;
import java.util.Scanner;
import banksystem.Main;
import banksystem.account.*;
import banksystem.options.*;
import static banksystem.menu.LoginMenu.login;

public class OptionsMenu {
    public void optionsClient(Client client, ArrayList<Client> clients, ArrayList<PreviousTransaction> previousTransactions) {
        boolean performAnotherOperation = true;
        do {
            System.out.print("\n1.Transaction" +
                             "\n2.Transaction History" +
                             "\n3.Account Details" +
                             "\n4.Edit Personal Information");
            if (client.isSavingsAccount)
            {
                System.out.print("\n5.Savings Account Details" +
                                 "\n6.Logout" +
                                 "\nSelect: ");
            }
            else
            {
                System.out.print("\n5.Logout" +
                                 "\nSelect: ");
            }

            Scanner input = new Scanner(System.in);
            int selection = Main.inputInt(input);

            if (selection == 1)
            {
                System.out.print("\n1.Deposit" +
                                 "\n2.Withdraw" +
                                 "\n3.Transfer" +
                                 "\nSelect: ");

                selection = Main.inputInt(input);

                if (selection == 1)
                    OptionsClient.depositMenu(client);
                else if (selection == 2)
                    OptionsClient.withdrawalMenu(client);
                else if (selection == 3)
                    OptionsClient.transferMenu(client);
                else
                    System.out.println("\nERROR: Invalid selection!");
            }
            else if (selection == 2)
                previousTransactions.getFirst().selectTransactionHistory(client, previousTransactions);
            else if (selection == 3)
                OptionsClient.displayAccountDetails(client);
            else if (selection == 4)
                OptionsClient.editPersonalInfo(client);
            else if (client.isSavingsAccount && selection == 5)
            {
                ClientSavings temp = new ClientSavings(client.balance);
                temp.savingsAccountDetails(client.balance, client);
            }
            else if (client.isSavingsAccount && selection == 6)
            {
                login();
                break;
            }
            else if (!client.isSavingsAccount && selection == 5)
            {
                login();
                break;
            }
            else {
                System.out.println("\nERROR: Invalid selection!");
                continue;
            }

            do {
                System.out.print("\nDo you wish to perform another operation in \"Client Options Menu\"? (y/n): ");
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

    public void optionsEmployee(Employee employee, ArrayList<Client> clients) {
        OptionsEmployee options = new OptionsEmployee();
        boolean performAnotherOperation = true;
        do {
            System.out.print("\n1.Client Accounts Management" +
                             "\n2.Client Account Details" +
                             "\n3.Edit Personal Information" +
                             "\n4.Logout" +
                             "\nSelect: ");

            Scanner input = new Scanner(System.in);
            int selection = Main.inputInt((input));

            if (selection == 1)
            {
                do {
                    System.out.print("\n1.Create new client account" +
                                     "\n2.Edit client account" +
                                     "\n3.Delete client account" +
                                     "\nSelect: ");

                    selection = Main.inputInt(input);

                    if (selection == 1)
                    {
                        options.createClientAccount();
                        break;
                    }
                    else if (selection == 2)
                    {
                        options.editClientAccount(options.searchClientAccount());
                        break;
                    }
                    else if (selection == 3)
                    {
                        options.deleteClientAccount(options.searchClientAccount());
                        break;
                    }
                    else
                        System.out.println("Error: Invalid selection!");
                } while (true);
            }
            else if (selection == 2)
                options.displayClientInformation(options.searchClientAccount());
            else if (selection == 3)
                options.editPersonalInfo(employee);
            else if (selection == 4)
            {
                login();
                break;
            }
            else
            {
                System.out.println("Invalid selection!");
                continue;
            }

            do {
                System.out.print("\nDo you wish to perform another operation in \"Employee Options Menu\"? (y/n): ");
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

    public void optionsAdmin(ArrayList<Client> clients, ArrayList<Employee> employees, ArrayList<PreviousTransaction> previousTransactions) {
        Admin admin = new Admin();
        OptionsAdmin options = new OptionsAdmin();

        boolean performAnotherOperation = true;
        do {
            System.out.print("\n1.Client Accounts Management" +
                             "\n2.Employee Accounts Management" +
                             "\n3.Display Transaction History" +
                             "\n4.Display Accounts" +
                             "\n5.Logout" +
                             "\nSelect: ");
            Scanner input = new Scanner(System.in);
            int selection = Main.inputInt(input);

            if (selection == 1)
            {
                do {
                    System.out.print("\n1.Create new client account" +
                                     "\n2.Edit client account" +
                                     "\n3.Delete client account" +
                                     "\nSelect: ");

                    selection = Main.inputInt(input);

                    if (selection == 1)
                    {
                        options.createClientAccount();
                        break;
                    }
                    else if (selection == 2)
                    {
                        options.editClientAccount(options.searchClientAccount());
                        break;
                    }
                    else if (selection == 3)
                    {
                        options.deleteClientAccount(options.searchClientAccount());
                        break;
                    }
                    else
                        System.out.println("Error: Invalid selection!");
                } while (true);
            }
            else if (selection == 2)
            {
                do {
                    System.out.print("\n1.Create new employee account" +
                                     "\n2.Edit employee account" +
                                     "\n3.Delete employee account" +
                                     "\nSelect: ");
                    selection = Main.inputInt(input);

                    if (selection == 1)
                    {
                        options.registerEmployeeAccount();
                        break;
                    }
                    else if (selection == 2)
                    {
                        options.editEmployeeAccount(options.searchEmployeeAccount());
                        break;
                    }
                    else if (selection == 3)
                    {
                        options.deleteEmployeeAccount(options.searchEmployeeAccount());
                        break;
                    }
                    else
                        System.out.println("Error: Invalid selection!");
                } while (true);
            }
            else if (selection == 3)
                options.displayTransactions();
            else if (selection == 4)
                options.displayAccounts();
            else if (selection == 5)
            {
                login();
                break;
            }
            else
            {
                System.out.println("Error: Invalid selection!");
                continue;
            }

            do {
                System.out.print("\nDo you wish to perform another operation in \"Admin Options Menu\"? (y/n): ");
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
}