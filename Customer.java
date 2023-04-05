public class Customer {
    private int customerID;
    private String name;

    public Customer(int customerID, String name) {
        this.customerID = customerID;
        this.name = name;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void displayCustomerInfos(){
        System.out.println("******************************");
        System.out.println("Customer's Infosℹ️");
        System.out.println("Customer's name🪪 = " + getName() );
        System.out.println("Customer ID🪪 = " + getCustomerID());
        System.out.println("******************************");
    }
}
