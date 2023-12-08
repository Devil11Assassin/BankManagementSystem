package banksystem.menu;

import banksystem.account.*;

import java.util.ArrayList;
import java.util.Scanner;

public class OptionsMenu {
    public void optionsClient(Client client, ArrayList<Client> clients) {
        boolean performAnotherOperation = true;
        do {
            System.out.print("\n1.Transaction\n" +
                             "2.Transaction History\n" +
                             "3.Account Details\n" +
                             "4.Edit Personal Information\n" +
                             "Select: ");

            Scanner input = new Scanner(System.in);
            int selection = input.nextInt();

            if (selection == 1) {
                System.out.print("\n1.Deposit\n" +
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
            } else if (selection == 2)
                client.showTransactionHistory(client);
            else if (selection == 3)
                client.displayAccountDetails();
            else if (selection == 4)
                client.editPersonalInfo(client);
            else {
                System.out.println("Invalid selection!\n");
                continue;
            }

            System.out.println("Do you wish to perform another operation? (y/n)");
            Scanner answerInput = new Scanner(System.in);

            char answer = answerInput.next().charAt(0);
            if (answer != 'y' && answer != 'Y')
                performAnotherOperation = false;

        } while (performAnotherOperation);
    }

    public void optionsEmployee(Employee employee, ArrayList<Client> clients) {
        boolean performAnotherOperation = true;
        do {
            System.out.print("1.Client Accounts Management\n" +
                             "2.Client Account Details\n" +
                             "3.Edit Personal Information\n" +
                             "Select: ");

            Scanner input = new Scanner(System.in);
            int selection = input.nextInt();

            boolean invalidSelection = true;
            if (selection == 1) {
                do {
                    System.out.print("\n1.Create new client account\n" +
                                     "2.Edit client account\n" +
                                     "3.Delete client account\n" +
                                     "Select: ");

                    selection = input.nextInt();
                    if (selection == 1) {
                        invalidSelection = false;
                        employee.createClientAccount(clients);
                    } else if (selection == 2) {
                        invalidSelection = false;
                        employee.editClientAccount(employee.searchClientAccount(clients), clients);
                    } else if (selection == 3) {
                        invalidSelection = false;
                        employee.deleteClientAccount(clients, employee.searchClientAccount(clients));
                    } else
                        System.out.println("Error: Invalid selection!");
                } while (invalidSelection);
            } else if (selection == 2)
                employee.displayClientInformation(employee.searchClientAccount(clients));
            else if (selection == 3)
                employee.editPersonalInfo();
            else {
                System.out.println("Invalid selection!");
                continue;
            }

            System.out.println("Do you wish to perform another operation? (y/n)");
            Scanner answerInput = new Scanner(System.in);

            char answer = answerInput.next().charAt(0);
            if (answer != 'y' && answer != 'Y')
                performAnotherOperation = false;

        } while (performAnotherOperation);
    }

    public void optionsAdmin(ArrayList<Client> clients, ArrayList<Employee> employees) {
        Admin admin = new Admin();

        boolean performAnotherOperation = true;
        do {
            System.out.print("1.Employee Accounts Management\n" +
                             "2.Display Transaction History\n" +
                             "3.Display Accounts\n" +
                             "\nSelection: ");
            Scanner input = new Scanner(System.in);
            int selection = input.nextInt();

            if (selection == 1) {
                //employee account registration
                //employee account modification
                //employee account deletion
            } else if (selection == 2) {
                boolean isInvalid = true;
                do {
                    System.out.print("\nType of Transaction:\n" +
                                     "        1.Deposit\n" +
                                     "        2.Withdrawal\n" +
                                     "        3.Transfer\n" +
                                     "\nSelection: ");
                    selection = input.nextInt();

                    switch (selection) {
                        case 1: {
                            admin.displayDepositTransactions(admin.searchClientAccount(clients));
                            isInvalid = false;
                            break;
                        }
                        case 2: {
                            admin.displayWithdrawalTransactions(admin.searchClientAccount(clients));
                            isInvalid = false;
                            break;
                        }
                        case 3: {
                            admin.displayTransferTransactions(admin.searchClientAccount(clients));
                            isInvalid = false;
                            break;
                        }
                        default: System.out.println("Error: Invalid selection!");
                    }
                } while (isInvalid);
            } else if (selection == 3)
                admin.displayAccounts(clients, employees);
            else {
                System.out.println("Error: Invalid selection!");
                continue;
            }

            System.out.println("Do you wish to perform another operation? (y/n)");
            Scanner answerInput = new Scanner(System.in);

            char answer = answerInput.next().charAt(0);
            if (answer != 'y' && answer != 'Y')
                performAnotherOperation = false;

        } while (performAnotherOperation);
    }
}