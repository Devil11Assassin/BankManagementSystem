package banksystem;

import banksystem.account.*;
import static banksystem.menu.LoginMenu.login;

import java.time.LocalDateTime;
import java.util.Scanner;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Main {
    static File clientsFile = new File("clients.txt");
    static File employeesFile = new File("employees.txt");
    static File transactionsFile = new File("transactions.txt");

    public static ArrayList<Client> clients = new ArrayList<>();
    public static ArrayList<Employee> employees = new ArrayList<>();
    public static ArrayList<PreviousTransaction> previousTransactions = new ArrayList<>();

    public static void main(String[] args) {
        readFile();

        login();

        writeFile();

        System.exit(0);
    }

    //I/O Methods
    public static void readFile() {
        //Clients
        try (Scanner file = new Scanner(new File(String.valueOf(clientsFile))))
        {
            while (file.hasNextLine())
            {
                Client client = new Client();

                client.firstName = file.nextLine();
                client.lastName = file.nextLine();
                client.setPhoneNumber(Long.parseLong(file.nextLine()));
                client.setAddress(file.nextLine());

                client.setUsername(file.nextLine());
                client.setPassword(file.nextLine());
                client.setAccountID(Integer.parseInt(file.nextLine()));

                client.setAccountState(Boolean.parseBoolean(file.nextLine()));
                client.balance = Float.parseFloat(file.nextLine());
                client.isSavingsAccount = Boolean.parseBoolean(file.nextLine());

                clients.add(client);
                file.nextLine();
            }
        } catch (Exception e) {
            System.out.println("Exception encountered in clients' input stream.");
        }

        //Employees
        try (Scanner file = new Scanner(new File(String.valueOf(employeesFile))))
        {
            while (file.hasNextLine())
            {
                Employee employee = new Employee();

                employee.firstName = file.nextLine();
                employee.lastName = file.nextLine();
                employee.setPhoneNumber(Long.parseLong(file.nextLine()));
                employee.setAddress(file.nextLine());

                employee.setUsername(file.nextLine());
                employee.setPassword(file.nextLine());
                employee.setAccountID(Integer.parseInt(file.nextLine()));

                employee.uniGraduated = file.nextLine();
                employee.yearOfGraduation = Integer.parseInt(file.nextLine());
                employee.setGrade(file.nextLine());
                employee.setPosition(file.nextLine().charAt(0));
                employee.setAdminAccess(Boolean.parseBoolean(file.nextLine()));

                employees.add(employee);
                file.nextLine();
            }
        } catch (Exception e) {
            System.out.println("Exception encountered in employees' input stream.");
        }

        //Transactions
        try (Scanner file = new Scanner(new File(String.valueOf(transactionsFile))))
        {
            while (file.hasNextLine())
            {
                PreviousTransaction transaction = new PreviousTransaction();

                transaction.clientID = Integer.parseInt(file.nextLine());
                transaction.dateAndTime = LocalDateTime.parse(file.nextLine());
                transaction.afterTransaction = Float.parseFloat(file.nextLine());
                transaction.beforeTransaction = Float.parseFloat(file.nextLine());
                transaction.type = PreviousTransaction.Type.valueOf(file.nextLine());

                previousTransactions.add(transaction);
                file.nextLine();
            }
        } catch (Exception e) {
            System.out.println("Exception encountered in transactions' input stream.");
        }
    }
    public static void writeFile() {
        //Clients
        try (BufferedWriter file = new BufferedWriter(new FileWriter(clientsFile)))
        {
            for (Client client : Main.clients)
            {
                file.write(client.firstName); file.newLine();
                file.write(client.lastName); file.newLine();
                file.write(String.valueOf(client.getPhoneNumber())); file.newLine();
                file.write(client.getAddress()); file.newLine();

                file.write(client.getUsername()); file.newLine();
                file.write(client.getPassword()); file.newLine();
                file.write(String.valueOf(client.getAccountID())); file.newLine();

                file.write(String.valueOf(client.getAccountStateIsActive())); file.newLine();
                file.write(String.valueOf(client.balance)); file.newLine();
                file.write(String.valueOf(client.isSavingsAccount)); file.newLine(); file.newLine();
            }
        } catch (Exception e) {
            System.out.println("Exception encountered in clients' output stream.");
        }

        //Employees
        try (BufferedWriter file = new BufferedWriter(new FileWriter(employeesFile)))
        {
            for (Employee employee : Main.employees)
            {
                file.write(employee.firstName); file.newLine();
                file.write(employee.lastName); file.newLine();
                file.write(String.valueOf(employee.getPhoneNumber())); file.newLine();
                file.write(employee.getAddress()); file.newLine();

                file.write(employee.getUsername()); file.newLine();
                file.write(employee.getPassword()); file.newLine();
                file.write(String.valueOf(employee.getAccountID())); file.newLine();

                file.write(employee.uniGraduated); file.newLine();
                file.write(String.valueOf(employee.yearOfGraduation)); file.newLine();
                file.write(String.valueOf(employee.getGrade())); file.newLine();
                file.write(employee.getPosition()); file.newLine();
                file.write(String.valueOf(employee.getAdminAccess())); file.newLine(); file.newLine();
            }
        } catch (Exception e) {
            System.out.println("Exception encountered in employees' output stream.");
        }

        //Transactions
        try (BufferedWriter file = new BufferedWriter(new FileWriter(transactionsFile)))
        {
            for (PreviousTransaction transaction : previousTransactions)
            {
                file.write(String.valueOf(transaction.clientID)); file.newLine();
                file.write(transaction.dateAndTime.toString()); file.newLine();
                file.write(String.valueOf(transaction.afterTransaction)); file.newLine();
                file.write(String.valueOf(transaction.beforeTransaction)); file.newLine();
                file.write(transaction.type.name()); file.newLine(); file.newLine();
            }
        } catch (Exception e) {
            System.out.println("Exception encountered in transactions' output stream.");
        }
    }

    //Scanner Input Methods
    public static int inputInt(Scanner input) {
        do {
            try
            {
                int temp = input.nextInt();
                input.nextLine();
                return temp;
            }
            catch (InputMismatchException e)
            {
                System.out.print("\nError: Invalid input!\n Enter a number: ");
                input.nextLine();
            }
        } while (true);
    }
    public static float inputFloat(Scanner input) {
        do {
            try
            {
                float temp = input.nextFloat();
                input.nextLine();
                return temp;
            }
            catch (InputMismatchException e)
            {
                System.out.print("\nError: Invalid input!\n Enter a number: ");
                input.nextLine();
            }
        } while (true);
    }
    public static long inputLong(Scanner input) {
        do {
            try
            {
                long temp = input.nextLong();
                input.nextLine();
                return temp;
            }
            catch (InputMismatchException e)
            {
                System.out.print("\nError: Invalid input!\n Enter a number: ");
                input.nextLine();
            }
        } while (true);
    }

    //Checks
    public static boolean checkUsername(String username) {
        if (username.equals("admin"))
            return true;

        for (Client client : clients){
            if (username.equals(client.getUsername()))
                return true;
        }

        for (Employee employee : employees){
            if (username.equals(employee.getUsername()))
                return true;
        }

        return false;
    }
    public static boolean checkPassword(String password){
        return password.equals("admin");
    }
    public static boolean checkClientID(int id) {
        for (Client client : clients)
            if (id == client.getAccountID())
                return true;

        return false;
    }
    public static boolean checkEmployeeID(int id) {
        for (Employee employee : employees)
            if (id == employee.getAccountID())
                return true;

        return false;
    }
}