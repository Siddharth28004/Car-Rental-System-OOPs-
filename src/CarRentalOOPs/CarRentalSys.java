package CarRentalOOPs;
import java.util.*;

public class CarRentalSys {

    class Car{
        private String carID;
        private String brand;
        private String model;
        private double basepriceperday;
        private boolean isAvailable;

        public Car(String carID, String brand, String model, double basepriceperday){
            this.carID=carID;
            this.brand=brand;
            this.model=model;
            this.basepriceperday=basepriceperday;
            this.isAvailable=true;
        }
        public String getCarID(){
            return carID;
        }
        public String getBrand(){
            return brand;
        }
        public String getModel(){
            return model;
        }
        public double calculatetotalprice(int rentaldays){
            return basepriceperday*rentaldays;
        }
        public boolean isAvailable(){
            return isAvailable;
        }
        public void rent(){
            isAvailable=false;
        }
        public void returnCar(){
            isAvailable=true;
        }


    }

    class Rental{
        private Customer  customer;
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

    class Customer{
        private String customername;
        private String customerId;

        public Customer(String customername, String customerId){
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

    class RentalSystem{
        private List <Car> cars;
        private List <Customer> customers;
        private List <Rental> rentals;

        public RentalSystem(){
            cars= new ArrayList<>();
            customers=new ArrayList<>();
            rentals=new ArrayList<>();
        }

        public void addCar(Car car){
            cars.add(car);
        }
        public void addCustomer(Customer customer){
            customers.add(customer);
        }
        public void addRental(Rental rental){
            rentals.add(rental);
        }

        public void rentCar(Car car, Customer customer, int days){
            if(car.isAvailable()){
                car.rent();
                rentals.add(new Rental(car,customer,days));
            }
        }
    }


    public static void main(String[] args) {
        System.out.println("hello");

    }







}
