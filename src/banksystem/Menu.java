package banksystem;

import banksystem.account.SavingsAccount;
import banksystem.person.Client;
import banksystem.person.Employee;

import java.util.ArrayList;

public class Menu {
    public void login(ArrayList<Client> clients, ArrayList<Employee> employees,
                      ArrayList<SavingsAccount> savingsAccounts, String username,
                      String password){
        for (int i = 0; i<clients.size(); i++)
            if (username.equals(clients.get(i).username));
    }
}
