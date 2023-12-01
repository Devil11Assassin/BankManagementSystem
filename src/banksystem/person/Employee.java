package banksystem.person;

import java.util.ArrayList;
import java.util.Date;

public class Employee extends Person {
    protected int employeeAccountID;
    protected char employeePosition;
    public String uniGraduated;
    public Date yearOfGraduation;
    protected char[] totalGrade;
    public static int employeeCount;
    private final boolean ADMIN_ACCESS = false;


    public Employee(String fName, String lName, Double pNumber, String address,
                    int employeeAccountID, char employeePosition, String uniGraduated,
                    Date yearOfGraduation, char[] totalGrade) {
        super(fName, lName, pNumber, address);
        this.employeeAccountID = employeeAccountID;
        this.employeePosition = employeePosition;
        this.uniGraduated = uniGraduated;
        this.yearOfGraduation = yearOfGraduation;
        this.totalGrade[0] = totalGrade[0];
        this.totalGrade[1] = totalGrade[1];
        employeeCount++;
    }


//    public int getEmployeeAccountID() {
//        return EmployeeAccountID;
//    }
//
//    public void setEmployeeAccountID(int employeeAccountID) {
//        EmployeeAccountID = employeeAccountID;
//    }
//
//    public char getEmployeePosition() {
//        return EmployeePosition;
//    }
//
//    public void setEmployeePosition(char employeePosition) {
//        EmployeePosition = employeePosition;
//    }


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
        for (int i = 0; i < Client.clientCount; i++) {
            if (ClientID == clients.get(i).getClientAccountID()) {
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

    public Client searchClientAccount(ArrayList<Client> clients, String fName, String lName) {
        boolean found = false;
        int index = 0;
        for (int i = 0; i < Client.clientCount; i++) {
            if (fName.equals(clients.get(i).firstName) && lName.equals(clients.get(i).lastName)) {
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

    public void editPersonalInfo(Employee employee, int pNumber) {
        employee.phoneNumber = pNumber;

    }

    public void editPersonalInfo(Employee employee, String address) {
        employee.address = address;
    }

    public void editPersonalInfo(Employee employee, char EPosition) {
        employee.employeePosition = EPosition;
    }

    public void editPersonalInfo(Employee employee, int pNumber, String address) {
        employee.phoneNumber = pNumber;
        employee.address = address;

    }

    public void editPersonalInfo(Employee employee, String address, char EPosition) {

        employee.address = address;
        employee.employeePosition = EPosition;
    }

    public void editPersonalInfo(Employee employee, int PNumber, char EPosition) {
        employee.phoneNumber = PNumber;
        employee.employeePosition = EPosition;
    }
}