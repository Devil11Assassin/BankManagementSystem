package banksystem.account;

import java.util.ArrayList;
import java.util.Scanner;

public class Admin extends Employee{

    public void authorizeEmployeeRegistration(boolean Authorized, Employee employee) {
        if (Authorized)
            System.out.println("Account registration authorized!");
        else if (!Authorized)
            System.out.println("Account registration unauthorized!");
        else {
            System.out.println("Cannot complete authorization. Error: Invalid authorization (T/F only)!");
            employee = null;
        }
    }

    public void displayAccounts(ArrayList<Client> clients, ArrayList<Employee> employees) {
        Scanner input = new Scanner(System.in);

        System.out.println("Select which account type to display: (Client/Employee)");
        String answer = input.nextLine();

        if (answer.equals("Client")) {
            for (int i = 0; i < Client.clientCount; i++) {
                //  clients.get(i).DisplayAccountDetails;
            }
        } else if (answer.equals("Employee")) {
            for (int i = 0; i < Employee.employeeCount; i++) {
                // Employee[i].DisplayAccountDetails;
            }
        } else
            System.out.println("Cannot display accounts. Error: Invalid account type!");
    }

    public void displayTransactions(ArrayList<Client> clients){

    }
}