package me.berniga;

/**
 * @author : Christian Berniga
 * @class : 4 D
 * @created : 17/01/2022, lunedì
 **/
public class Car {
    private int id;
    private int seats;
    private String plateNumber;
    private String brand;

    public Car(int seats,String plateNumber,String brand){
        this.seats= seats;
        this.plateNumber=plateNumber;
        this.brand=brand;
    }

    public Car(int id,int seats,String plateNumber,String brand){
        this.id=id;
        this.seats= seats;
        this.plateNumber=plateNumber;
        this.brand=brand;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getSeats() {
        return seats;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public String getBrand() {
        return brand;
    }

    @Override
    public String toString(){
       // return brand;
        return id+";"+seats+";"+plateNumber+";"+brand;
    }
}
