package banksystem;

import banksystem.account.*;
import banksystem.menu.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Client> clients = new ArrayList<>();
        ArrayList<Employee> employees = new ArrayList<>();

        /*FileProcessing fileProcessing = new FileProcessing();
        fileProcessing.fromFileIntoArray(clients, employees);*/

        clients.add(new Client("Muhammad", "Mounir", 201010068689L, "El-Khalafawi, Shoubra",
                "da", "123", 50, true, 10000));

        /*char[] grade = new char[2]{'+','A'};
        employees.add(new Employee("Mohamed", "Abdelnasser", 201032918180L, "High, far, wherever you are",
                "ma", "456", 0, 'M', "Ain Shams Faculty of Computer & Information Science",
                2026, grade, false));*/

        LoginMenu loginMenu = new LoginMenu();
        loginMenu.login(clients, employees);


        /*fileProcessing.fromArrayIntoFile(clients, employees);
        System.exit(0);*/
    }
}
