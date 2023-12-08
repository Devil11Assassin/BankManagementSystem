package banksystem.account;

import java.util.ArrayList;
import java.util.Scanner;

public class Employee extends Account {
    protected int employeeAccountID;
    protected char employeePosition;
    public String uniGraduated;
    public int yearOfGraduation;
    protected char totalGradePart1;
    protected char totalGradePart2;
    public static int employeeCount;
    private boolean adminAccess;

    public Employee() {
        super();
    }

    public Employee(String fName, String lName, long pNumber, String address,
                    String username, String password, int employeeAccountID,
                    char employeePosition, String uniGraduated,
                    int yearOfGraduation, char totalGradePart1, char totalGradePart2, boolean adminAccess) {

        super(fName, lName, pNumber, address, username, password);
        this.employeeAccountID = employeeAccountID;
        this.employeePosition = employeePosition;
        this.uniGraduated = uniGraduated;
        this.yearOfGraduation = yearOfGraduation;
        this.totalGradePart1 = totalGradePart1;
        this.totalGradePart2 = totalGradePart2;
        this.adminAccess = adminAccess;
        employeeCount++;
    }


    public int getEmployeeAccountID() {
        return employeeAccountID;
    }

    public void setEmployeeAccountID(int employeeAccountID) {
        this.employeeAccountID = employeeAccountID;
    }

    public char getEmployeePosition() {
        return employeePosition;
    }

    public void setEmployeePosition(char employeePosition) {
        this.employeePosition = employeePosition;
    }

    public boolean getAdminAccess() {
        return adminAccess;
    }

    public void setAdminAccess(boolean adminAccess) {
        this.adminAccess = adminAccess;
    }


    public void editPersonalInfo() {
        boolean repeat = true;
        do {
            System.out.print("\nSelect attribute to modify:\n" +
                             "        1.Phone number\n" +
                             "        2.Address\n" +
                             "        3.Position\n" +
                             "Selection:");
            Scanner input = new Scanner(System.in);
            int selection = input.nextInt();

            switch (selection) {
                case 1: {
                    System.out.print("New phone number: ");
                    this.phoneNumber = input.nextLong();
                    System.out.println("Phone number edited successfully!");
                    break;
                }
                case 2: {
                    System.out.print("New address: ");
                    this.address = input.nextLine();
                    System.out.println("Address edited successfully!");
                    break;
                }
                case 3: {
                    System.out.print("New position: ");
                    this.employeePosition = input.next().charAt(0);
                    System.out.println("Position edited successfully!");
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

    public void createClientAccount(ArrayList<Client> clients) {
        System.out.println(" --- CLIENT ACCOUNT CREATION --- \n" +
                           "Input details of the new account:\n" +
                           "---------------------------------\n");
        Scanner input = new Scanner(System.in);

        System.out.print("First name: ");
        String firstName = input.nextLine();

        System.out.print("Last name: ");
        String lastName = input.nextLine();

        System.out.print("Phone number: ");
        long phoneNumber = input.nextLong();

        System.out.print("Address: ");
        String address = input.nextLine();

        boolean isFound;

        String username;
        do {
            isFound = false;

            System.out.print("Username: ");
            username = input.nextLine();

            for (Client client : clients) {
                if (username.equals("admin") || username.equals(client.getUsername())) {
                    isFound = true;
                    System.out.println("Error: Username already exists!");
                    break;
                }
            }
        } while (isFound);

        String password;
        do {
            isFound = false;

            System.out.print("Password: ");
            password = input.nextLine();

            if (password.equals("admin")) {
                isFound = true;
                System.out.println("Error: Forbidden password!");
            }
        } while (isFound);

        int ID;
        do {
            isFound = false;

            System.out.print("ID: ");
            ID = input.nextInt();
            for (Client client : clients) {
                if (ID == client.getClientAccountID()) {
                    isFound = true;
                    System.out.println("Error: ID already exists!");
                    break;
                }
            }
        } while (isFound);

        clients.add(new Client(firstName, lastName, phoneNumber, address,
                username, password, ID, true, 0));
    }

    public void editClientAccount(Client client, ArrayList<Client> clients) {
        boolean repeat = true;
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
                             "Selection:");
            Scanner input = new Scanner(System.in);
            int selection = input.nextInt();

            switch (selection) {
                case 1: {
                    System.out.print("New firstname: ");
                    client.firstName = input.nextLine();
                    System.out.println("Firstname modified successfully!");
                    break;
                }
                case 2: {
                    System.out.print("New lastname: ");
                    client.lastName = input.nextLine();
                    System.out.println("Lastname modified successfully!");
                    break;
                }
                case 3: {
                    System.out.print("New Phone number: ");
                    client.phoneNumber = input.nextLong();
                    System.out.println("Phone number modified successfully!");
                    break;
                }
                case 4: {
                    System.out.print("New address: ");
                    client.address = input.nextLine();
                    System.out.println("Address modified successfully!");
                    break;
                }
                case 5: {
                    boolean isFound;
                    String username;

                    do {
                        isFound = false;
                        System.out.print("New username: ");
                        username = input.nextLine();

                        for (Client tempClient : clients) {
                            if (username.equals("admin") || username.equals(tempClient.getUsername())) {
                                isFound = true;
                                System.out.println("Error: Username already exists!");
                                break;
                            }
                        }
                    } while (isFound);

                    client.username = username;
                    System.out.println("Username modified successfully!");
                    break;
                }
                case 6: {
                    boolean isFound;
                    String password;
                    do {
                        isFound = false;
                        System.out.print("New password: ");
                        password = input.nextLine();

                        if (password.equals("admin")) {
                            isFound = true;
                            System.out.println("Error: Forbidden password!");
                        }
                    } while (isFound);

                    client.setPassword(password);
                    System.out.println("Password modified successfully!");
                    break;
                }
                case 7: {
                    System.out.print("New account state (T/F): ");
                    char answer = input.next().charAt(0);

                    if (answer == 't' || answer == 'T')
                        client.setAccountState(true);
                    else if (answer == 'f' || answer == 'F')
                        client.setAccountState(false);

                    System.out.println("Account state modified successfully!");
                    break;
                }
                case 8: {
                    System.out.print("New balance: ");
                    client.balance = input.nextInt();
                    System.out.println("Balance modified successfully!");
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

    public void deleteClientAccount(ArrayList<Client> clients, Client client) {
        if (client == null)
            System.out.println("Account deletion failed: Account doesn't exist!");
        else {
            clients.remove(client);
            Client.clientCount--;
            System.out.println("Account deletion successful!");
        }
    }

    public void displayClientInformation(Client client) {
        System.out.println("\nClient Information:\n" +
                           "-------------------");
        client.displayAccountDetails();
    }

    public Client searchClientAccount(ArrayList<Client> clients) {
        boolean invalid = true;
        do {
            System.out.print("\nSearch for the client by:\n" +
                             "        1.Username" +
                             "        2.ID" +
                             "Selection: ");
            Scanner input = new Scanner(System.in);
            int selection = input.nextInt();

            if (selection == 1) {
                invalid = false;

                System.out.print("Username: ");
                String clientUsername = input.nextLine();

                for (Client client : clients) {
                    if (clientUsername.equals(client.getUsername()))
                        return client;
                }
            } else if (selection == 2) {
                invalid = false;

                System.out.print("ID: ");
                int clientID = input.nextInt();

                for (Client client : clients) {
                    if (clientID == client.getClientAccountID())
                        return client;
                }
            } else
                System.out.println("Error: Invalid selection!");
        } while (invalid);

        System.out.println("Account doesn't exist!");
        return null;
    }
}