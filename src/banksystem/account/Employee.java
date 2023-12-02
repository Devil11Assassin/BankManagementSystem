package banksystem.account;

import java.util.ArrayList;
import java.util.Date;

public class Employee extends Account {
    protected int employeeAccountID;
    protected char employeePosition;
    public String uniGraduated;
    public int yearOfGraduation;
    protected char[] totalGrade;
    public static int employeeCount;
    private boolean adminAccess;

    public Employee() {
        super();
    }

    public Employee(String fName, String lName, long pNumber, String address,
                    String username, String password, int employeeAccountID,
                    char employeePosition, String uniGraduated,
                    int yearOfGraduation, char[] totalGrade, boolean adminAccess) {

        super(fName, lName, pNumber, address, username, password);
        this.employeeAccountID = employeeAccountID;
        this.employeePosition = employeePosition;
        this.uniGraduated = uniGraduated;
        this.yearOfGraduation = yearOfGraduation;
        this.totalGrade[0] = totalGrade[0];
        this.totalGrade[1] = totalGrade[1];
        this.adminAccess = adminAccess;
        employeeCount++;
    }


    public int getEmployeeAccountID() {
        return employeeAccountID;
    }

    public void setEmployeeAccountID(int employeeAccountID) {
        employeeAccountID = employeeAccountID;
    }

    public char getEmployeePosition() {
        return employeePosition;
    }

    public void setEmployeePosition(char employeePosition) {
        employeePosition = employeePosition;
    }

    public boolean getAdminAccess() {
        return adminAccess;
    }

    public void setAdminAccess(boolean adminAccess) {
        this.adminAccess = adminAccess;
    }


    public void editClientAccount(Client client) {

    }

    public void deleteClientAccount(Client client) {
        client = null;
        Client.clientCount--;
    }

    public void createClientAccount(ArrayList<Client> clients) {
        // clients.add(Client.clientCount, new Client());
    }

    public Client searchClientAccount(ArrayList<Client> clients, int ClientID) {
        boolean found = false;
        int index = 0;
        for (int i = 0; i < clients.size(); i++) {
            if (ClientID == clients.get(i).getClientAccountID()) {
                found = true;
                index = i;
                break;
            }
        }
        if (found)
            return clients.get(index);
        else {
            System.out.println("Account doesn't exist!");
            return null;
        }
    }

    public Client searchClientAccount(ArrayList<Client> clients, String username) {
        boolean found = false;
        int index = 0;
        for (int i = 0; i < Client.clientCount; i++) {
            if (username.equals(clients.get(i).username)) {
                found = true;
                index = i;
            } else {
                System.out.println("Account doesn't exist!");
            }
        }
        if (found)
            return clients.get(index);
        else
            return null;
    }


    public void editPersonalInfo(Employee employee, int pNumber, String address, char EPosition) {
        employee.phoneNumber = pNumber;
        employee.address = address;
        employee.employeePosition = EPosition;
    }
}