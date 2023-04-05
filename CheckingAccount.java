public class CheckingAccount extends BankAccount {
    private double fee;

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public CheckingAccount(int accountID, double balance, double fee,Customer accountOwner) {
        super(accountID, balance,accountOwner);
        this.fee = fee;
    }

    @Override
    public void deposit(double amount) {
        if(amount<0){
            System.out.println("Your amount can not be negative❌");
        }else if(!(amount >fee)){
            System.out.println("This transaction (deposit " + amount + ") is not approved. In order to effectively increase the balance, the amount to deposit should be greater than the fee.");
        }
        else setBalance(getBalance() + (amount-fee));
    }

    @Override
    public void withdraw(double amount) {
        if(amount<0){
            System.out.println("Amount can not be negative❌");
        }else if(getBalance()< fee + amount){
            System.out.println("You can not withdraw because fee + amount greater than your Balance🏦💸");
        }else
            setBalance(getBalance()-(fee + amount));
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Fee🫰" + getFee());
    }
}
