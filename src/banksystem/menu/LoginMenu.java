package banksystem.menu;

import banksystem.account.*;

import java.util.ArrayList;
import java.util.Scanner;

public class LoginMenu {
    public void login(ArrayList<Client> clients, ArrayList<Employee> employees) {
        String username;
        String password;
        boolean loginSuccessful = false;
        Scanner input = new Scanner(System.in);

        System.out.println("\t*** LOGIN ***\n\t=============\n");
        do {
            System.out.print("Enter your username: ");
            username = input.nextLine();
            System.out.print("Enter your password: ");
            password = input.nextLine();

            if (username.equals("admin") && password.equals("admin")) {
                loginSuccessful = true;
                System.out.println("\n\t---LOGGED IN AS ADMIN---\n\t--- 2FA   INITIATION ---\n");
                loginAdminVerification(employees);
            }
            else {
                for (Client client : clients) {
                    if (username.equals(client.getUsername()) && password.equals(client.getPassword())) {
                        loginSuccessful = true;
                        System.out.println("\n\t---LOGGED IN AS CLIENT---\n");
                        OptionsMenu clientOptionsMenu = new OptionsMenu();
                        clientOptionsMenu.optionsClient(client, clients);
                    }
                }
                for (Employee employee : employees) {
                    if (username.equals(employee.getUsername()) && password.equals(employee.getPassword())) {
                        loginSuccessful = true;
                        System.out.println("\n\t---LOGGED IN AS EMPLOYEE---\n");
                        //run employee options
                    }
                }
            }
            if (!loginSuccessful)
                System.out.println("\nLogin Failed: Incorrect username or password!\n\n" +
                        "\t--------------------------\n" +
                        "\tRESTARTING LOGIN OPERATION\n" +
                        "\t--------------------------\n");
        } while (!loginSuccessful);
    }



    public void loginAdminVerification(ArrayList<Employee> employees){

        Scanner input = new Scanner(System.in);
        boolean loginSuccessful = false;

        System.out.print("Username: ");
        String username = input.nextLine();
        System.out.print("Password: ");
        String password = input.nextLine();

        for (Employee employee : employees) {
            if (username.equals(employee.getUsername()) && password.equals(employee.getPassword()) && employee.getAdminAccess()) {
                loginSuccessful = true;
                break;
            }
        }
        if (loginSuccessful){
            System.out.println("\t---2FA SUCCESSFUL---\n\tWelcome back "+username+"!");
            //run admin options
        }
        else{
            System.out.println("\t-----2FA FAILED-----\n\t---ABORTING LOGIN---\n");
        }
    }
}