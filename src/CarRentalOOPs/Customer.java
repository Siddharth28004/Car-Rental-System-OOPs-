package CarRentalOOPs;

public class Customer {
    private String customername;
    private String customerId;

    public Customer(String customerId, String customername){
        this.customerId=customerId;
        this.customername=customername;
    }

    public String getCustomerId(){
        return customerId;
    }
    public String getCustomername(){
        return customername;
    }
}
