package banksystem.account;

import banksystem.person.Client;
import banksystem.person.Employee;

import java.util.ArrayList;

import static banksystem.person.Client.clientCount;

public abstract class Admin {

    public static final String ACCESS_TYPE = "Admin";

    public void AuthorizeEmployeeRegistration(boolean Authorized, Employee employee) {
        if (Authorized)
            System.out.println("Account registration authorized!");
        else if (!Authorized)
            System.out.println("Account registration unauthorized!");
        else {
            System.out.println("Cannot complete authorization. Error: Invalid authorization (T/F only)!");
            employee = null;
        }
    }

    public void DisplayAccounts(String accountType, String AccessType, ArrayList<Client> clients) {
        if (AccessType.equals("Admin")) {
            if (accountType.equals("Client")) {
                for (int i = 0; i < clientCount; i++) {
                    //  clients.get(i).DisplayAccountDetails;
                }
            } else if (accountType.equals("Employee")) {
                for (int i = 0; i < Employee.employeeCount; i++) {
                    // Employee[i].DisplayAccountDetails;
                }
            } else
                System.out.println("Cannot display accounts. Error: Invalid account type!");
        } else if (AccessType.equals("Client") || AccessType.equals("Employee"))
            System.out.println("Cannot display accounts. Error: Access Denied!");
        else
            System.out.println("Unable to set password.\nError: Access Denied!");
    }
}