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
                rentals.add(new Rental(customer, car,days));
            }
            else{
                System.out.println("Car is not available for rent");
            }

        }

        public void returnCar(Car car){
            car.returnCar();
            Rental rentaltoremove=null;
            for( Rental rental: rentals){
                if(rental.getCar()==car){
                    rentaltoremove=rental;
                    break;
                }
            }
            if(rentaltoremove!=null){
                rentals.remove(rentaltoremove);
                System.out.println("Car returned successfully!");

            }
            else{
                System.out.println("Car was not rented. Please input details correctly or verify if the car was rented in the first place");
            }

        }

        public void menu(){
            Scanner scanner = new Scanner(System.in);
            while(true){
                System.out.println("==== Car Rental System ====");
                System.out.println("1. Rent a Car");
                System.out.println("2. Return a Car");
                System.out.println("3.Exit");
                System.out.print("Enter your choice: ");

                int choice= scanner.nextInt();

                if(choice==1){
                    System.out.println("\n===Rent a Car===\n");
                    System.out.println("Enter your name");
                    String customername= scanner.nextLine();

                    System.out.println("\n Available Cars:-");
                    for(Car car:cars){
                        if(car.isAvailable){
                            System.out.println(car.getCarID()+"-"+car.getBrand()+" "+car.getModel());
                        }

                    }
                    System.out.println("\n Enter the carID of the car that you would like to rent:");
                    String carId = scanner.nextLine();

                    System.out.println("Enter the number of days you would like to rent for: ");
                    int rentaldays= scanner.nextInt();
                    scanner.nextLine();

                    Customer newcustomer= new Customer("CUS"+(customers.size()+1), customername);
                    addCustomer(newcustomer);

                    Car selectedcar=null;
                    for(Car car:cars){
                        if(car.getCarID().equals(carId)&&car.isAvailable()){
                            selectedcar=car;
                            break;
                        }
                    }

                    if(selectedcar!=null){
                        double total price= selectedcar.calculatetotalprice(rentaldays);//part of Car class attribs

                    }






                }
            }





            }
    }


    public static void main(String[] args) {
        System.out.println("hello");


    }







}
