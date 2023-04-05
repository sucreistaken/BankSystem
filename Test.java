import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {


        ArrayList<BankAccount> bankAccounts = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean check = true;
        String accountType;
        int option;
        int nextAccountID = 1; // The accountID numbers will be assigned automatically by the program to make each and every accountID use a unique value
        int tempCustomerID;
        double tempBalance;
        String tempCustomerName;
        double amount;
        double cost = 2; // fee per each transaction of CheckingAccount
        double interest = 0.08; // interestRate of SavingsAccount
        BankAccount tempAccountRef = null;
        while (check) {
            displayMenu();
            int input = scanner.nextInt();
            switch (input) {
                case 1:
                    System.out.println("Please enter Account Owner's name");
                    tempCustomerName = scanner.next();
                    System.out.println("Please enter the Account Owner ID");
                    tempCustomerID = Integer.parseInt(scanner.next());
                    System.out.println("Please enter the initial balance value ₺");
                    tempBalance = scanner.nextDouble();
                    Customer owner = new Customer(tempCustomerID, tempCustomerName);
                    do {
                        System.out.print("Which account type is considered? (enter either \"CA\" for CheckingAccount or \"SA\" for Savings Account : ");
                        accountType = scanner.nextLine();
                        // Depending the type choice a new account object will be created
                        if (accountType.equals("CA") || accountType.equals("ca")) {
                            tempAccountRef = new CheckingAccount(nextAccountID, tempBalance, cost, owner);
                            System.out.println("A new CheckingAccount is created. Remember that the fee per each transaction is 2 TL.");
                            break; // break do-while
                        } else if (accountType.equals("SA") || accountType.equals("sa")) {
                            tempAccountRef = new SavingsAccount(tempCustomerID, tempBalance, interest, owner);
                            System.out.println("A new SavingsAccount is created. Remember that the interest rate is 8% (0.08).");
                            break;
                        } else { // If the type entered is invalid, the loop keeps on running and the program asks for re-entering a valid type
                            System.out.println("Reconsider the account type please!");
                        }
                    }
                        while (true) ;
                            bankAccounts.add(tempAccountRef);
                            tempCustomerID++;
                            break;
                case 2:
                    System.out.println("Please enter credentials");
                    System.out.println("Owner's name");
                    tempCustomerName = scanner.next();
                    System.out.println("Enter customer ID");
                    tempCustomerID = scanner.nextInt();
                    tempAccountRef = Search(bankAccounts,tempCustomerName,tempCustomerID);
                    if(tempAccountRef != null){
                        System.out.println("Welcome " + tempCustomerName);
                    }
                    System.out.println("How many ₺ do you want to deposit");
                    amount = scanner.nextDouble();
                    tempAccountRef.deposit(amount);
                    System.out.println("Now your balance is " + tempAccountRef.getBalance());
                    break;
                case 3:
                    System.out.println("Please enter credentials");
                    System.out.println("Owner's name");
                    tempCustomerName = scanner.next();
                    System.out.println("Enter customer ID");
                    tempCustomerID = scanner.nextInt();
                    tempAccountRef = Search(bankAccounts,tempCustomerName,tempCustomerID);
                    if(tempAccountRef != null){
                        System.out.println("Welcome " + tempCustomerName);
                        System.out.println("How many ₺ do you want to withdraw");
                        amount = scanner.nextDouble();
                        tempAccountRef.withdraw(amount);
                        System.out.println("Your currently amount" + tempAccountRef.getBalance());
                    }
                case 4:
                    System.out.println("Please enter credentials");
                    System.out.println("Owner's name");
                    tempCustomerName = scanner.next();
                    System.out.println("Enter customer ID");
                    tempCustomerID = scanner.nextInt();
                    tempAccountRef = Search(bankAccounts,tempCustomerName,tempCustomerID);
                    if(tempAccountRef != null){
                        tempAccountRef.printInfo();
                    }else System.out.println("User not found");
                    break;
                case 5:
                    System.out.println("See you again...");
                    check = false;
                    break;
                default:
                    System.out.println("Please choose Valid Option");

            }

        }
    }
        public static void displayMenu () {
            System.out.println("MENU OPTIONS [1 through 5]:");
            System.out.println("*** Press 1 to open a new account for a new customer ***");
            System.out.println("*** Press 2 to deposit money to an account           ***");
            System.out.println("*** Press 3 to withdraw money from an account        ***");
            System.out.println("*** Press 4 to display an account info               ***");
            System.out.println("*** Press 5 to terminate the program                 ***");
            System.out.println();
            System.out.print("Your choice? : ");

        }
        public  static BankAccount Search(ArrayList<BankAccount> item,String name,int id){
        for(BankAccount bankAccount : item){
            if (bankAccount.getAccountOwner().getName().equals(name) && bankAccount.getAccountOwner().getCustomerID() == id){
                return bankAccount;
            }
        }
        return null;
        }
    }
