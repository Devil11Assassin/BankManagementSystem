package banksystem.options;

import java.util.Scanner;
import banksystem.Main;
import banksystem.account.Client;
import banksystem.account.Employee;

public class OptionsEmployee {
    //Employee Details Methods
    public void editPersonalInfo(Employee employee) {
        boolean repeat = true;
        do {
            System.out.print("\nSelect attribute to modify:\n" +
                             "        1.Phone number\n" +
                             "        2.Address\n" +
                             "Selection: ");
            Scanner input = new Scanner(System.in);
            int selection = input.nextInt();
            input.nextLine();

            switch (selection) {
                case 1: {
                    System.out.print("New phone number: ");
                    employee.setPhoneNumber(input.nextLong());
                    System.out.println("Phone number edited successfully!");
                    break;
                }
                case 2: {
                    System.out.print("New address: ");
                    employee.setAddress(input.nextLine());
                    System.out.println("Address edited successfully!");
                    break;
                }
                default: {
                    System.out.println("Invalid selection!");
                    continue;
                }
            }

            System.out.println("Do you wish to modify another attribute? (y/n)");
            char answer = input.next().charAt(0);
            if (answer != 'y' && answer != 'Y')
                repeat = false;

        } while (repeat);
    }

    public void displayEmployeeInformation(Employee employee) {
        employee.displayInformation();
    }

    public void displayEmployeeIdentification(Employee employee) {
        employee.displayIdentification();
    }

    //Client Accounts Management Methods
    public void createClientAccount() {
        System.out.println(" --- CLIENT ACCOUNT CREATION --- \n" +
                           "Input details of the new account:\n" +
                           "---------------------------------\n");
        Scanner input = new Scanner(System.in);

        System.out.print("First name: ");
        String firstName = input.nextLine();

        System.out.print("Last name: ");
        String lastName = input.nextLine();

        System.out.print("Phone number: ");
        long phoneNumber = Main.inputLong(input);

        System.out.print("Address: ");
        String address = input.nextLine();

        boolean isFound;

        String username;
        do {
            isFound = false;

            System.out.print("Username: ");
            username = input.nextLine();

            for (Client client : Main.clients)
            {
                if (username.equals("admin") || username.equals(client.getUsername()))
                {
                    isFound = true;
                    System.out.println("ERROR: Username already exists!");
                    break;
                }
            }
        } while (isFound);

        String password;
        do {
            isFound = false;

            System.out.print("Password: ");
            password = input.nextLine();

            if (password.equals("admin"))
            {
                isFound = true;
                System.out.println("ERROR: Forbidden password!");
            }
        } while (isFound);

        int ID;
        do {
            isFound = false;

            System.out.print("ID: ");
            ID = Main.inputInt(input);

            for (Client client : Main.clients)
            {
                if (ID == client.getAccountID())
                {
                    isFound = true;
                    System.out.println("ERROR: ID already exists!");
                    break;
                }
            }
        } while (isFound);

        boolean isValid;
        char answer;
        boolean isSavingsAccount = false;
        do {
            isValid = false;

            System.out.print("Savings Account (Y/N): ");
            answer = input.next().charAt(0);

            if (answer == 'Y' || answer == 'y')
            {
                isSavingsAccount = true;
                isValid = true;
            }
            else if (answer == 'N' || answer == 'n')
            {
                isValid = true;
            }
            else
            {
                System.out.println("Error: Invalid input!");
            }
        } while (!isValid);

        Employee employee = new Employee();
        employee.createClientAccount(firstName, lastName, phoneNumber,
                address, username, password, ID, isSavingsAccount);
    }
    public void editClientAccount(Client client) {
        if (client == null)
        {
            System.out.println("Account modification failed: Account doesn't exist!");
        }
        else
        {
            boolean repeat = true;
            Employee employee = new Employee();

            do {
                System.out.print("\nSelect attribute to modify:\n" +
                                 "        1.Firstname\n" +
                                 "        2.Lastname\n" +
                                 "        3.Phone number\n" +
                                 "        4.Address\n" +
                                 "        5.Username\n" +
                                 "        6.Password\n" +
                                 "        7.Account State\n" +
                                 "        8.Balance\n" +
                                 "        9.Savings Account Status\n" +
                                 "Selection:");
                Scanner input = new Scanner(System.in);
                int selection = Main.inputInt(input);

                switch (selection)
                {
                    case 1: {
                        System.out.print("New firstname: ");
                        employee.editClientFirstName(client, input.nextLine());
                        System.out.println("Firstname modified successfully!");
                        break;
                    }
                    case 2: {
                        System.out.print("New lastname: ");
                        employee.editClientLastName(client, input.nextLine());
                        System.out.println("Lastname modified successfully!");
                        break;
                    }
                    case 3: {
                        System.out.print("New Phone number: ");
                        employee.editClientPhoneNumber(client, Main.inputInt(input));
                        System.out.println("Phone number modified successfully!");
                        break;
                    }
                    case 4: {
                        System.out.print("New address: ");
                        employee.editClientAddress(client, input.nextLine());
                        System.out.println("Address modified successfully!");
                        break;
                    }
                    case 5: {
                        String username;
                        do {
                            System.out.print("New username: ");
                            username = input.nextLine();

                            if (Main.checkUsername(username))
                                System.out.println("ERROR: Username already exists!");
                            else
                                break;
                        } while (true);

                        employee.editClientUsername(client, username);
                        System.out.println("Username modified successfully!");
                        break;
                    }
                    case 6: {
                        String password;
                        do {
                            System.out.print("New password: ");
                            password = input.nextLine();

                            if (Main.checkPassword(password))
                                System.out.println("ERROR: Forbidden password!");
                            else
                                break;
                        } while (true);

                        employee.editClientPassword(client, password);
                        System.out.println("Password modified successfully!");
                        break;
                    }
                    case 7: {
                        do {
                            System.out.print("New account state (T/F): ");
                            char answer = input.next().charAt(0);

                            if (answer == 't' || answer == 'T')
                                employee.editClientAccountState(client, true);
                            else if (answer == 'f' || answer == 'F')
                                employee.editClientAccountState(client, false);
                            else
                            {
                                System.out.println("ERROR: Enter a valid state!");
                                continue;
                            }

                            break;
                        } while (true);

                        System.out.println("Account state modified successfully!");
                        break;
                    }
                    case 8: {
                        System.out.print("New balance: ");
                        employee.editClientBalance(client, Main.inputFloat(input));
                        System.out.println("Balance modified successfully!");
                        break;
                    }
                    case 9: {
                        char answer;
                        do {
                            System.out.print("New 'Savings' status (Y/N): ");
                            answer = input.next().charAt(0);

                            if (answer == 'Y' || answer == 'y')
                                client.isSavingsAccount = true;
                            else if (answer == 'N' || answer == 'n')
                                client.isSavingsAccount = false;
                            else {
                                System.out.println("Error: Invalid input!");
                                continue;
                            }

                            break;
                        } while (true);

                        System.out.println("'Savings Account' status modified successfully!");
                        break;
                    }
                    default: {
                        System.out.println("Invalid selection!");
                        continue;
                    }
                }

                do {
                    System.out.print("Do you wish to modify another attribute? (y/n): ");
                    char answer = input.next().charAt(0);
                    if (answer == 'y' || answer == 'Y')
                        break;
                    else if (answer == 'n' || answer == 'N')
                    {
                        repeat = false;
                        break;
                    }
                    else
                        System.out.println("Invalid input: Enter (y/n) only!");
                } while (true);
            } while (repeat);
        }
    }

    public void deleteClientAccount(Client client) {
        if (client == null)
            System.out.println("Account deletion failed: Account doesn't exist!");
        else {
            Employee employee = new Employee();
            employee.deleteClientAccount(client);
            System.out.println("Account deletion successful!");
        }
    }

    public void displayClientInformation(Client client) {
        if (client == null)
            System.out.println("Client Information fetch failed: Account doesn't exist!");
        else {
            System.out.println("\nClient Information" +
                               "\n------------------");
            Employee employee = new Employee();
            employee.displayClientInformation(client);
        }
    }

    public Client searchClientAccount() {
        Employee employee = new Employee();

        do {
            System.out.print("\nSearch clients by:\n" +
                             "        1.Username\n" +
                             "        2.ID\n" +
                             "Selection: ");
            Scanner input = new Scanner(System.in);
            int selection = Main.inputInt(input);

            if (selection == 1)
            {
                System.out.print("Username: ");
                String clientUsername = input.nextLine();
                return employee.searchClientAccount(clientUsername);
            }
            else if (selection == 2)
            {
                System.out.print("ID: ");
                int clientID = Main.inputInt(input);
                return employee.searchClientAccount(clientID);
            }
            else
            {
                System.out.println("Error: Invalid selection!");
            }
        } while (true);
    }
}
