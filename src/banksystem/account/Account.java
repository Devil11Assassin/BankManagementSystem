package banksystem.account;

public class Account {
    protected String username;
    private String password;
    private String accessType;

    public Account(String username, String password, String accessType) {
        this.username = username;
        this.password = password;
        this.accessType = accessType;
    }

    public String getUsername(String accessType) {
        return username;
    }

    public String getAccessType(){
        return accessType;
    }

    public void setAccessType(String accessTypeOfCaller, String accessType){
        if (accessType.equals("Client") && (accessTypeOfCaller.equals("Employee") || accessTypeOfCaller.equals("Admin")))
            this.accessType = accessType;
        else if (accessType.equals("Employee") && accessTypeOfCaller.equals("Admin"))
            this.accessType = accessType;
        else
            System.out.println("Invalid Access Type");
    }

    public void setUsername(String username, String accessType) {
        if (accessType.equals("Employee") || accessType.equals("Admin"))
            this.username = username;
        else if (accessType.equals("Client"))
            System.out.println("Unable to set username.\nError: Access Denied!");
        else
            System.out.println("Unable to set username.\nError: Invalid Access Type!");
    }

    public String getPassword(String accessType) {
        if (accessType.equals("Admin"))
            return password;
        else if (accessType.equals("Client") || accessType.equals("Employee"))
            return "Unable to return password.\nError: Access Denied!";
        else
            return "Unable to set username.\nError: Invalid Access Type!";
    }

    public void setPassword(String password, String accessType) {
        if (accessType.equals("Employee") || accessType.equals("Admin"))
            this.password = password;
        else
            System.out.println("Unable to set password.\nError: Access Denied!");
    }
}