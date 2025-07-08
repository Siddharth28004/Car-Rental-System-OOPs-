package CarRentalOOPs;

public class Rental {
    private Customer customer;
    private Car car;
    private int days;
    public Rental(Customer customer, Car car, int days){
        this.car=car;
        this.customer=customer;
        this.days=days;
    }

    public Car getCar(){
        return car;
    }
    public Customer getCustomer(){
        return customer;
    }
}
