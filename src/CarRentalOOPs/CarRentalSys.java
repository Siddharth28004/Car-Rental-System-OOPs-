package CarRentalOOPs;
import java.util.*;

public class CarRentalSys {

    static class Car{
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

    static class Rental{
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

    static class Customer{
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

     static class RentalSystem{
        private List <Car> cars;
        private List <Customer> customers;
        private List <Rental> rentals;

        public RentalSystem(){ //creating array lists to store
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
                car.rent();//makes it false for future use
                rentals.add(new Rental(customer, car,days)); //adding the infor to rentals arraylist
            }
            else{
                System.out.println("Car is not available for rent");
            }

        }

        public void returnCar(Car car){
            car.returnCar();//is an attrib of the Car class
            Rental rentaltoremove=null;
            for( Rental rental: rentals){ //traversing the arraylist
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
                scanner.nextLine();

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

                    Customer newcustomer= new Customer("CUS"+(customers.size()+1), customername);//refer customer class for attribs
                    addCustomer(newcustomer);

                    Car selectedcar=null;
                    for(Car car:cars){
                        if(car.getCarID().equals(carId)&&car.isAvailable()){
                            selectedcar=car;
                            break;
                        }
                    }

                    if(selectedcar!=null){
                        double totalprice= selectedcar.calculatetotalprice(rentaldays);//part of Car class attribs
                        System.out.println("\n===Rental Information==\n");
                        System.out.println("Customer ID: "+newcustomer.getCustomerId());
                        System.out.println("Customer Name: "+newcustomer.getCustomername());
                        System.out.println("Car: "+selectedcar.getBrand()+" "+selectedcar.getModel());
                        System.out.println("Rental days: "+rentaldays);
                        System.out.printf("Total price:₹%.2f%n",totalprice);/*  okay so here what it means is first i used ₹ symbol
                        then  %.2f here % starts it .2 means upto 2decimal place and f means float and %n newline can use/n also */
                        System.out.println("\n Confirm your rental (Y/N): ");
                        String confirm=scanner.nextLine();

                        if(confirm.equalsIgnoreCase("Y")){ //basically using equals with Ignore case ensures case insensitivity
                            rentCar(selectedcar,newcustomer,rentaldays); //constructor part of Rental System class
                            System.out.println("\n Car rented successfully!");

                        }
                        else{
                            System.out.println("\n Rental Cancelled");

                        }
                    }
                    else{
                        System.out.println("Invalid selection or Car is not available to rent");

                    }

                }

                else if(choice==2){
                    System.out.println("\n===Return a Car===");
                    System.out.println("Enter the ID of the car you want to return: ");
                    String carId= scanner.nextLine();

                    Car cartoreturn=null;

                    for(Car car:cars){
                        if(car.getCarID().equals(carId)&&!car.isAvailable()){
                            cartoreturn=car;
                            break;
                        }
                    }

                    if(cartoreturn!=null){
                        Customer customer=null;
                        for(Rental rental: rentals){
                            if(rental.getCar()==cartoreturn){
                                customer=rental.getCustomer();
                                break;
                            }

                        }
                        if(customer!=null){
                            returnCar(cartoreturn);
                            System.out.println("Car returned successfully by: "+customer.getCustomername());
                        }
                        else{
                            System.out.println("Car was not rented or some information provided is missing");

                        }
                    }

                    else{
                        System.out.println("Invalid Car ID or Car was not rented");
                    }

                }

                else if(choice==3){
                    break;
                }

                else{
                    System.out.println("Invalid choice, please enter again.");
                }
            }

            System.out.println("\n Thank you for using this Car rental system!!");
            }
    }


    public static void main(String[] args) {
        RentalSystem rentalSystem= new RentalSystem();
        Car car1 = new Car("C001", "Ford", "Mustang", 100.0); // Different base price per day for each car
        Car car2 = new Car("C002", "Honda", "Accord", 40.0);
        Car car3 = new Car("C003", "Mahindra", "Thar", 80.0);
        Car car4 = new Car("C004", "Porsche", "911", 180.0);
        rentalSystem.addCar(car1);
        rentalSystem.addCar(car2);
        rentalSystem.addCar(car3);
        rentalSystem.addCar(car4);
        rentalSystem.menu();
    }

}
