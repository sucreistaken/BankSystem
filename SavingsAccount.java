public class SavingsAccount extends BankAccount {
    private double interestRate;

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public SavingsAccount(int accountID, double balance, double interestRate,Customer owner) {
        super(accountID, balance,owner);
        this.interestRate = interestRate;
    }

    @Override
    public void deposit(double amount){
        if(amount<0){
            System.out.println("The transaction has not been approved❌\n" + "Your amount can not be negative" );
        }else setBalance((getBalance() + amount) * (1+getInterestRate()));
    }
    @Override
    public void withdraw(double amount){
            if(amount>0){
                if(amount>getBalance()){
                    setBalance(getBalance()-amount);
                }else System.out.println( "Insufficient balance🪙❌");
            }else System.out.println("Your amount can not be negative❌");
    }
    @Override
    public void printInfo(){
        super.printInfo();
        System.out.println("Interest Rate💸💱" + getInterestRate());
    }
}
