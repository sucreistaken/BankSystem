public abstract class BankAccount implements Transactions {
    private int accountID;

    public Customer getAccountOwner() {
        return accountOwner;
    }

    public void setAccountOwner(Customer accountOwner) {
        this.accountOwner = accountOwner;
    }

    private Customer accountOwner;
    public BankAccount(int accountID, double balance,Customer accountOwner) {
        this.accountID = accountID;
        this.balance = balance;
        this.accountOwner=accountOwner;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    private double balance;

    public void printInfo() {
        System.out.println("Account ID🪪" + getAccountID());
        System.out.println("Balance💲" + getBalance());
        accountOwner.displayCustomerInfos();
    }

}
