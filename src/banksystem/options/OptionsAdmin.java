package banksystem.options;

import banksystem.Main;
import banksystem.account.Admin;
import banksystem.account.Client;
import banksystem.account.Employee;
import banksystem.account.PreviousTransaction;

import java.util.Scanner;

public class OptionsAdmin extends OptionsEmployee {
    //Client Management Methods
    @Override
    public void editClientAccount(Client client) {
        if (client == null)
        {
            System.out.println("Account modification failed: Account doesn't exist!");
        }
        else
        {
            boolean repeat = true;
            Admin admin = new Admin();

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
                                 "       10.ID\n" +
                                 "Selection:");
                Scanner input = new Scanner(System.in);
                int selection = Main.inputInt(input);

                switch (selection)
                {
                    case 1: {
                        System.out.print("New firstname: ");
                        admin.editClientFirstName(client, input.nextLine());
                        System.out.println("Firstname modified successfully!");
                        break;
                    }
                    case 2: {
                        System.out.print("New lastname: ");
                        admin.editClientLastName(client, input.nextLine());
                        System.out.println("Lastname modified successfully!");
                        break;
                    }
                    case 3: {
                        System.out.print("New Phone number: ");
                        admin.editClientPhoneNumber(client, Main.inputInt(input));
                        System.out.println("Phone number modified successfully!");
                        break;
                    }
                    case 4: {
                        System.out.print("New address: ");
                        admin.editClientAddress(client, input.nextLine());
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

                        admin.editClientUsername(client, username);
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

                        admin.editClientPassword(client, password);
                        System.out.println("Password modified successfully!");
                        break;
                    }
                    case 7: {
                        do {
                            System.out.print("New account state (T/F): ");
                            char answer = input.next().charAt(0);

                            if (answer == 't' || answer == 'T')
                                admin.editClientAccountState(client, true);
                            else if (answer == 'f' || answer == 'F')
                                admin.editClientAccountState(client, false);
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
                        admin.editClientBalance(client, Main.inputFloat(input));
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
                    case 10: {
                        int id;

                        do {
                            System.out.print("ID: ");
                            id = Main.inputInt(input);

                            if (Main.checkClientID(id))
                                System.out.println("Error: ID already exists!");
                            else
                                break;
                        } while (true);

                        client.setAccountID(id);
                        System.out.println("Client ID successfully modified!");
                        break;
                    }
                    default: {
                        System.out.println("ERROR: Invalid selection!");
                        continue;
                    }
                }

                do {
                    System.out.print("Do you wish to modify another attribute? (y/n): ");
                    char answer = input.next().charAt(0);
                    if (answer == 'y' || answer == 'Y') {
                        break;
                    } else if (answer == 'n' || answer == 'N') {
                        repeat = false;
                        break;
                    } else
                        System.out.println("Invalid input: Enter (y/n) only!");
                } while (true);
            } while (repeat);
        }
    }

    //Employee Management Methods
    public void registerEmployeeAccount() {
        System.out.println(" --- EMPLOYEE ACCOUNT CREATION --- \n" +
                           "Input details of the new account:\n" +
                           "---------------------------------\n");
        Scanner input = new Scanner(System.in);

        System.out.print("First name: ");
        String firstName = input.nextLine();

        System.out.print("Last name: ");
        String lastName = input.nextLine();


        System.out.print("Phone number: ");
        long phoneNumber;
        phoneNumber = Main.inputLong(input);

        System.out.print("Address: ");
        String address = input.nextLine();

        String username;
        do {
            System.out.print("Username: ");
            username = input.nextLine();

            if (Main.checkUsername(username))
                System.out.println("Error: Username already exists!");
            else
                break;
        } while (true);

        String password;
        do {
            System.out.print("Password: ");
            password = input.nextLine();

            if (Main.checkPassword(password))
                System.out.println("Error: Forbidden password!");
            else
                break;
        } while (true);

        int ID;
        do {
            System.out.print("ID: ");
            ID = Main.inputInt(input);

            if (Main.checkEmployeeID(ID))
                System.out.println("Error: ID already exists!");
            else
                break;
        } while (true);

        System.out.print("University graduated: ");
        String uniGraduated = input.nextLine();

        System.out.print("Graduation year: ");
        int graduationYear = Main.inputInt(input);

        System.out.print("Full Grade (+/ /-) (A/B/C/D): ");
        String gradeString = input.nextLine();

        char employeePosition = 'E';
        do {
            System.out.print("Employee position (M/E): ");
            char answer = input.next().charAt(0);

            if (answer == 'M' || answer == 'm') {
                employeePosition = 'M';
                break;
            } else if (answer == 'E' || answer == 'e')
                break;
            else
                System.out.println("Error: Invalid input! Enter (M/E) only!");
        } while (true);

        boolean adminAccess = false;
        do {
            System.out.print("Admin access (y/n): ");
            char answer = input.next().charAt(0);

            if (answer == 'y' || answer == 'Y') {
                adminAccess = true;
                break;
            } else if (answer == 'n' || answer == 'N')
                break;
            else
                System.out.println("Error: Invalid input! Enter (y/n) only!");
        } while (true);

        Admin admin = new Admin();
        admin.registerEmployeeAccount(firstName, lastName, phoneNumber, address, username, password,
                ID, uniGraduated, graduationYear, gradeString, employeePosition, adminAccess);
    }

    public void editEmployeeAccount(Employee employee) {
        if (employee == null)
            System.out.println("Account modification failed: Account doesn't exist!");
        else {
            boolean repeat = true;
            Admin admin = new Admin();
            do {
                System.out.print("\nSelect attribute to modify:" +
                                 "\n        1.Firstname" +
                                 "\n        2.Lastname" +
                                 "\n        3.Phone number" +
                                 "\n        4.Address" +
                                 "\n        5.Username" +
                                 "\n        6.Password" +
                                 "\n        7.ID" +
                                 "\n        8.University Graduated" +
                                 "\n        9.Graduation Year" +
                                 "\n       10.Grade" +
                                 "\n       11.Position" +
                                 "\n       12.Admin permissions" +
                                 "\nSelect: ");
                Scanner input = new Scanner(System.in);
                int selection = Main.inputInt(input);

                switch (selection) {
                    case 1: {
                        System.out.print("New firstname: ");
                        admin.editEmployeeFirstname(employee, input.nextLine());
                        System.out.println("Firstname modified successfully!");
                        break;
                    }
                    case 2: {
                        System.out.print("New lastname: ");
                        admin.editEmployeeLastname(employee, input.nextLine());
                        System.out.println("Lastname modified successfully!");
                        break;
                    }
                    case 3: {
                        System.out.print("New phone number: ");
                        admin.editEmployeePhoneNumber(employee, Main.inputLong(input));
                        System.out.println("Phone number modified successfully!");
                        break;
                    }
                    case 4: {
                        System.out.print("New address: ");
                        admin.editEmployeeAddress(employee, input.nextLine());
                        System.out.println("Address modified successfully!");
                        break;
                    }
                    case 5: {
                        String username;

                        do {
                            System.out.print("New username: ");
                            username = input.nextLine();

                            if (Main.checkUsername(username))
                                System.out.println("Error: Username already exists!");
                            else
                                break;
                        } while (true);

                        admin.editEmployeeUsername(employee, username);
                        System.out.println("Username modified successfully!");
                        break;
                    }
                    case 6: {
                        String password;

                        do {
                            System.out.print("New password: ");
                            password = input.nextLine();

                            if (Main.checkPassword(password))
                                System.out.println("Error: Forbidden password!");
                            else
                                break;
                        } while (true);

                        admin.editEmployeePassword(employee, password);
                        System.out.println("Password modified successfully!");
                        break;
                    }
                    case 7: {
                        int id;

                        do {
                            System.out.print("New employee ID: ");
                            id = Main.inputInt(input);

                                if (Main.checkEmployeeID(id))
                                    System.out.println("Error: ID already exists!");
                                else
                                    break;
                        } while (true);

                        admin.editEmployeeID(employee, id);
                        System.out.println("Employee ID modified successfully!");
                        break;
                    }
                    case 8: {
                        System.out.print("New 'University Graduated': ");
                        admin.editEmployeeUni(employee, input.nextLine());
                        System.out.println("'University graduated' modified successfully!");
                        break;
                    }
                    case 9: {
                        System.out.print("New graduation year: ");
                        admin.editEmployeeYearOfGraduation(employee, Main.inputInt(input));
                        System.out.println("'Graduation Year' modified successfully!");
                        break;
                    }
                    case 10: {
                        String gradeString;

                        do {
                            System.out.print("New grade: ");
                            gradeString = input.nextLine();

                            if (gradeString.length() > 2)
                                System.out.println("ERROR: Invalid grade!");
                            else
                                break;
                        } while (true);

                        admin.editEmployeeGrade(employee, gradeString);
                        System.out.println("Grade modified successfully!");
                        break;
                    }
                    case 11: {
                        char position;

                        do {
                            System.out.print("New position (M/E): ");
                            position = input.next().charAt(0);

                            if (position == 'M' || position == 'm')
                            {
                                admin.editEmployeePosition(employee, 'M');
                                break;
                            }
                            else if (position == 'E' || position == 'e')
                            {
                                admin.editEmployeePosition(employee, 'E');
                                break;
                            }
                            else
                                System.out.println("Error: Invalid position!");
                        } while (true);

                        System.out.println("Position modified successfully");
                        break;
                    }
                    case 12: {
                        if (employee.getPosition() != 'M' && !employee.getAdminAccess())
                        {
                            char position;
                            do {
                                System.out.print("New administrator access (Y/N): ");
                                position = input.next().charAt(0);

                                if (position == 'Y' || position == 'y')
                                {
                                    admin.editEmployeeAdminAccess(employee, true);
                                    break;
                                }
                                else if (position == 'N' || position == 'n')
                                {
                                    admin.editEmployeeAdminAccess(employee, false);
                                    break;
                                }
                                else
                                    System.out.println("Error: Invalid input!");
                            } while (true);

                            System.out.println("Administrator permissions modified successfully!");
                            break;
                        }
                        else
                            System.out.println("Error: Selected employee is a manager and has admin permissions!\n" +
                                               "'Admin permission' modification process aborted!");
                    }
                    default: {
                        System.out.println("Invalid selection!");
                        continue;
                    }
                }

                do {
                    System.out.print("Do you wish to modify another attribute? (y/n): ");
                    char answer = input.next().charAt(0);
                    if (answer == 'y' || answer == 'Y') {
                        break;
                    } else if (answer == 'n' || answer == 'N') {
                        repeat = false;
                        break;
                    } else
                        System.out.println("Invalid input: Enter (y/n) only!");
                } while (true);

            } while (repeat);
        }
    }

    public void deleteEmployeeAccount(Employee employee) {
        if (employee == null)
            System.out.println("Account deletion failed: Account doesn't exist!");
        else if (employee.getAdminAccess())
            System.out.println("Account deletion failed: Employee has administrator permissions!");
        else
        {
            Admin admin = new Admin();
            admin.deleteEmployeeAccount(employee);
            System.out.println("Account deletion successful!");
        }
    }

    public Employee searchEmployeeAccount() {
        Admin admin = new Admin();

        do {
            System.out.print("\nSearch employees by:\n" +
                             "        1.Username\n" +
                             "        2.ID\n" +
                             "Selection: ");
            Scanner input = new Scanner(System.in);
            int selection = Main.inputInt(input);

            if (selection == 1)
            {
                System.out.print("Username: ");
                String clientUsername = input.nextLine();
                return admin.searchEmployeeAccount(clientUsername);
            }
            else if (selection == 2)
            {
                System.out.print("ID: ");
                int employeeID = Main.inputInt(input);
                return admin.searchEmployeeAccount(employeeID);
            }
            else
            {
                System.out.println("Error: Invalid selection!");
            }
        } while (true);
    }

    //Other Methods
    public void displayAccounts() {
        Scanner input = new Scanner(System.in);

        System.out.print("Select which account type to display (Client/Employee): ");
        String answer = input.nextLine();

        Admin admin = new Admin();
        if (answer.equals("client") || answer.equals("Client") || answer.equals("CLIENT"))
            admin.displayAccounts('C');
        else if (answer.equals("employee") || answer.equals("Employee") || answer.equals("EMPLOYEE"))
            admin.displayAccounts('E');
        else
            System.out.println("Cannot display accounts. Error: Invalid account type!");
    }

    public void displayTransactions() {
        PreviousTransaction.showTransactionHistory(this.searchClientAccount().getAccountID(), PreviousTransaction.Type.ALL);
    }
}