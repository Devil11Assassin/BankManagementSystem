package banksystem.account;

import banksystem.person.Client;

public class SavingsAccount extends Account {
    private float interestRate;
    private int savingsAccountID;

    public SavingsAccount(String username, String password, Client client) {
        super(username, password, "Client");
        savingsAccountID = client.getClientAccountID();
        //interest

    }

    /*public boolean canLoan(int ClientAccountID)
    {
        if()
        {
            return true;
        }
        else
        {
            return false;
        }
    }*/
    public float calcInterest(float interest) {
        return interest;
    }
}