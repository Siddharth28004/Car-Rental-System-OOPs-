package CarRentalOOPs;
import java.util.*;

public class CarRentalSys {

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
