package banksystem;

import banksystem.account.*;
import banksystem.menu.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Client> clients = new ArrayList<>();
        ArrayList<Employee> employees = new ArrayList<>();
        ArrayList<PreviousTransaction> previousTransactions = new ArrayList<>();

        /*FileProcessing fileProcessing = new FileProcessing();
        fileProcessing.fromFileIntoArray(clients, employees);*/

        clients.add(new Client("Muhammad", "Mounir", 201010068689L, "El-Khalafawi, Shoubra",
                "da", "123", 50, true, 10000, true));

        clients.add(new Client("Ismael", "IbnOmk", 201010068689L, "3nd Omk, Egypt",
                "iio", "abc", 51, true, 20000, false));

        employees.add(new Employee("Mohamed", "Abdelnasser", 201032918180L, "High, far, wherever you are",
                "ma", "456", 0, "Ain Shams Faculty of Computer & Information Science",
                2026, '+', 'A', 'M', true));

        employees.add(new Employee("Nigga", "IbnAbook", 20L, "Low, close, wherever you are",
                "wa", "999", 1, "Ain Shams Faculty of Computer & Information Science",
                2026, '-', 'D', 'E', false));

        LoginMenu loginMenu = new LoginMenu();
        loginMenu.login(clients, employees, previousTransactions);

        /*fileProcessing.fromArrayIntoFile(clients, employees);
        System.exit(0);*/
    }
}
