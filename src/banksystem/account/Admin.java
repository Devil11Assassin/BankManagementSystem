package banksystem.account;

import banksystem.Main;

public class Admin extends Employee {
    //Employee Account Registration
    public void registerEmployeeAccount(String firstName, String lastName, long phoneNumber, String address, String username, String password, int ID,
                                        String uniGraduated, int graduationYear, String gradeString, char employeePosition, boolean adminAccess) {
        Main.employees.add(new Employee(firstName, lastName, phoneNumber, address, username, password,
                ID, uniGraduated, graduationYear, gradeString, employeePosition, adminAccess));
    }

    //Employee Account Modification
    public void editEmployeeFirstname(Employee employee, String firstName) {
        employee.firstName = firstName;
    }
    public void editEmployeeLastname(Employee employee, String lastName) {
        employee.lastName = lastName;
    }
    public void editEmployeePhoneNumber(Employee employee, long phoneNumber) {
        employee.setPhoneNumber(phoneNumber);
    }
    public void editEmployeeAddress(Employee employee, String address) {
        employee.setAddress(address);
    }

    public void editEmployeeUsername(Employee employee, String username) {
        employee.setUsername(username);
    }
    public void editEmployeePassword(Employee employee, String password) {
        employee.setPassword(password);
    }
    public void editEmployeeID(Employee employee, int ID) {
        employee.setAccountID(ID);
    }

    public void editEmployeeUni(Employee employee, String uniGraduated) {
        employee.uniGraduated = uniGraduated;
    }
    public void editEmployeeYearOfGraduation(Employee employee, int year) {
        employee.yearOfGraduation = year;
    }
    public void editEmployeeGrade(Employee employee, String grade) {
        employee.setGrade(grade);
    }
    public void editEmployeePosition(Employee employee, char position) {
        employee.setPosition(position);
    }
    public void editEmployeeAdminAccess(Employee employee, boolean adminAccess) {
        employee.setAdminAccess(adminAccess);
    }

    //Employee Account Deletion
    public void deleteEmployeeAccount(Employee employee) {
        Main.employees.remove(employee);
    }

    //Employee Account Search
    public Employee searchEmployeeAccount(String username) {
        for (Employee employee : Main.employees) {
            if (employee.getUsername().equals(username))
                return employee;
        }
        return null;
    }
    public Employee searchEmployeeAccount(int id) {
        for (Employee employee : Main.employees) {
            if (employee.getAccountID() == id)
                return employee;
        }
        return null;
    }

    //Other Methods
    public void displayAccounts(char type) {
        if (type == 'C')
        {
            for (Client client : Main.clients)
                client.displayAccountIdentification();
        }
        else if (type == 'E')
        {
            for (Employee employee : Main.employees)
                employee.displayIdentification();
        }
    }
}