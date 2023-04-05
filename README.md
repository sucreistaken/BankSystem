# BankSystem
Aim: Practising on the use of “interface” and “abstract class”.
1. This work covers a sample scenario to simulate simple transactions on the bank accounts.
Regarding the design of the scenario, a BankAccount inheritance hierarchy and an interface
that declares the required methods for transactions will be used. The high-level UML design, as
depicted in Figure 1, consists of an interface Transactions together with a
BankAccount inheritance hierarchy (i.e., an abstract class BankAccount and two concrete
subclasses SavingsAccount and CheckingAccount). After implementing the design,
implement also a class Test to test the scenario.
Figure 1. Design of the project using UML diagrams.
The interface Transactions will contain the following two public abstract method
declarations: deposit and withdraw. These methods return nothing and take a double
amount parameter. (The methods declared in an interface are implicitly public and
abstract.)
The class BankAccount implements the interface Transactions. Therefore, if we want to
make the class BankAccount a concrete class, then we must implement the methods of
Transactions (i.e., deposit and withdraw) in class BankAccount. However, regarding
the design stated above in the first paragraph and also shown in Figure 1, we want to specify the
class BankAccount as an abstract class. Hence, let’s not implement the methods of
Transactions in BankAccount. In this manner, the class BankAccount must be declared
abstract to avoid compilation error. By the way, we will not instantiate an object from class
BankAccount, but we will use it as a superclass for its subclasses. The abstract class
BankAccount has the common information (data members) about a usual bank account. These
common data are the following two private fields: int accountID and double balance.
Define the corresponding setter/getter methods and a parameterized constructor. Define also the
method printInfo. The method printInfo takes no value, prints out the information (all data
members) and returns no value.
From the superclass BankAccount, derive a subclass SavingsAccount to represent a type of
account which provides the client with a predetermined interest on the funds. Thus,
“SavingsAccount IS-A BankAccount”. The subclass SavingsAccount has an extra
private data member: double interestRate. Define the corresponding setter/getter
methods and a parameterized constructor. In accordance with the objective of displaying all
information, override the method printInfo.
The class SavingsAccount overrides (implements) the method deposit in the following
manner: First, the parameter amount needs to be validated (i.e., a valid amount value needs to be
positive). If the parameter value is invalid, the transaction must not be approved and the client must
be informed about the issue. Otherwise, after adding the amount to the balance value, the
balance will be increased by the interest value computed.
The class SavingsAccount overrides (implements) the method withdraw in the following
manner: First, the parameter amount needs to be validated (i.e., a valid amount value needs to be
positive). If the parameter value is invalid, the transaction must not be approved and the client must
be informed about the issue. Else if the amount to withdraw is greater than the balance, the
transaction must not be approved and the client must be informed about the issue. Otherwise, the
transaction will be approved and so the amount will be subtracted from the balance.
From the superclass BankAccount, derive another subclass CheckingAccount to represent a
type of account which allows the transactions with an additional fee. Thus, “CheckingAccount
IS-A BankAccount”. The subclass CheckingAccount has an extra private data member:
double fee. Define the corresponding setter/getter methods and a parameterized constructor. In
accordance with the objective of displaying all information, override the method printInfo.
The class CheckingAccount overrides (implements) the method deposit in the following
manner: First, the parameter amount needs to be validated (i.e., a valid amount value needs to be
positive). If the parameter value is invalid, the transaction must not be approved and the client must
be informed about the issue. Else if the amount to deposit is not greater than the fee, the
transaction must not be approved and the client must be informed about the issue. Otherwise, the
transaction will be approved and so after cutting the fee, the amount will be added to the
balance.
The class CheckingAccount overrides (implements) the method withdraw in the following
manner: First, the parameter amount needs to be validated (i.e., a valid amount value needs to be
positive). If the parameter value is invalid, the transaction must not be approved and the client must
be informed about the issue. Else if the balance is less than the sum of the fee and the amount to
withdraw, the transaction must not be approved and the client must be informed about the issue.
Otherwise, the transaction will be approved and so both the fee and the amount will be subtracted
from the balance.
The class Test will contain the method main. In main, construct some instances from
CheckingAccount and some instances from SavingsAccount. Then, simulate some
transactions on these accounts. By the way, to display the balance values, print the information
of the accounts before and after the transactions. In main, test also that a concrete subclass object
can be referred by an abstract superclass reference. Furthermore, test that a reference of an object
can be assigned to an interface variable if the class of the corresponding reference implements the
interface.
2. In this part, the work is to implement the following relationship: “BankAccount HAS-A
Customer”. So, modify your project implemented in Question#1 in the following manner:
Implement another class Customer. The class Customer has the following two private
attributes: int customerID and String name. Define the corresponding setter/getter
methods and a parameterized constructor. Define another method displayCustomerInfo to
print out the information.
Modify the class BankAccount to implement the following relationship considered:
“BankAccount HAS-A Customer”. For this reason, in class BankAccount, add the
following private instance variable: Customer accountOwner. This data member will refer to
the owner of the account. In class BankAccount, define also corresponding setter/getter methods
for this data member. In class BankAccount, update the definitions of parameterized constructor
and printInfo methods accordingly. By the way, the parameterized constructors of the classes
SavingsAccount and CheckingAccount should also be revised.
Modify the class Test in the following manner: Suppose that you have a bank with some accounts
to be owned by some customers. In main, to represent a bank, use an instance from ArrayList
of BankAccount. At the beginning of the program, display a menu with 5 options. The first
option lets the user instantiate a new account to be owned by a new customer. The second option
lets the user deposit money. The third option lets the user withdraw money. The fourth option lets
the user print the information of an account in the bank. The last option lets the user terminate the
program.
When the user chooses the first option to create a new account, the user will enter the personal data
of the new account owner (customer) to be created, the account’s initial balance value and the type
of account. Depending on the account type the program will instantiate either a savings account or a
checking account using the parameterized constructor of the corresponding class (the rest of the
required parameters have the following initial values: regular interestRate of savings accounts
of the bank is 0.08, transaction fee of checking accounts of the bank is 2 TL). Then, the reference
of this account will be added into the bank.
Whenever the user chooses any of the second, third or fourth options of the menu to deal with an
account in the bank, the user will enter the credentials (customerID and name) of the customer.
Then, if an account in the bank matches with these credentials, the necessary menu operation will
be acted on the account found. Otherwise, no action on any account will be triggered and the user
will be informed about the issue.
The program keeps on running until the user chooses the last option.
As an illustration, the following sample menu may be considered:
Welcome to SE116-BANK…
MENU OPTIONS [1 through 5]:
*** Press 1 to open a new account for a new customer ***
*** Press 2 to deposit money to an account ***
*** Press 3 to withdraw money from an account ***
*** Press 4 to display an account info ***
*** Press 5 to terminate the program ***
Your choice? :
