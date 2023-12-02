package banksystem.account;

public class ClientSavings {
    private float interestRate;

    public ClientSavings() {
        super();
    }

    public ClientSavings(float interestRate) {
        this.interestRate = interestRate;
    }

    /*public boolean canLoan(int ClientAccountID)
    {
        if() { return true;}
        else {return false;}
    }*/

    public float getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(float interestRate) {
        this.interestRate = interestRate;
    }


    public class Loan {

        private float loanAmount;

        public Loan(float loanAmount, Client client) {
            this.loanAmount = loanAmount;
            client.balance += loanAmount;
        }

        public float calculateLoan() {
            return loanAmount * (1 + interestRate);
        }

        public float returnRequiredLoanAmount(float loanAmount, float interestRate) {
            return loanAmount / (1 + interestRate);
        }

        public float returnApplicableLoan(float balance) {
            return balance / 10000;
        }

        public float getLoanAmount() {
            return loanAmount;
        }

        public void setLoanAmount(float loanAmount) {
            this.loanAmount = loanAmount;
        }

    }
}