package CarRentalOOPs;

public class Car {
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
