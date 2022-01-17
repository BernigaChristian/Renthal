package me.berniga;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author : Christian Berniga
 * @class : 4 D
 * @created : 17/01/2022, lunedì
 **/
public class Renthal {
    private static final int MAX_CARS=10;
    private Car[] cars;
    private int registered=0;

    public Renthal(){cars=new Car[MAX_CARS];}

    public void addCar(Car c){
        c.setId(registered);
        cars[registered++]=c;
    }

    public void removeCar(String plateNumber)   throws CarNotFoundException{
        for(int i=0;i<cars.length;i++)
            if(cars[i]!=null&&cars[i].getPlateNumber().equalsIgnoreCase(plateNumber))  cars[i]=null;
        throw new CarNotFoundException();
    }

    public void removeCar(int id)   throws CarNotFoundException{
        for(int i=0;i<cars.length;i++)
            if(cars[i]!=null&&cars[i].getId()==id)  cars[i]=null;
        throw new CarNotFoundException();
    }

    public String getCarInfo(String plateNumber)    throws CarNotFoundException{
        for(Car c:cars)
            if(c!=null&&c.getPlateNumber().equalsIgnoreCase(plateNumber))    return c.toString();
        throw new CarNotFoundException();
    }

    public String getCarInfo(int id)    throws CarNotFoundException{
        for(Car c:cars)
            if(c!=null&&c.getId()==id)    return c.toString();
        throw new CarNotFoundException();
    }

    public ArrayList<String> getCarsBySeats(int seats)  throws CarNotFoundException{
        ArrayList<String> carsBySeats=new ArrayList<>();
        for(Car c:cars)
            if(c!=null&&c.getSeats()==seats)    carsBySeats.add(c.toString());
        if(carsBySeats.size()==0)   throw new CarNotFoundException();
        return carsBySeats;
    }

    public ArrayList<String> carByBrand()   throws CarNotFoundException{
        ArrayList<String> brands=new ArrayList<>();
        boolean notYet=true;
        for(int i=0;i<cars.length;i++){
            for(int j=0;j<i;j++)
                if(cars[i]!=null&&cars[j]!=null&&cars[i].getBrand().equalsIgnoreCase(cars[j].getBrand())) notYet=false;
            if(cars[i]!=null&&notYet)  brands.add(cars[i].getBrand());
            notYet=true;
        }
        if(brands.size()==0)    throw new CarNotFoundException();
        for(int i=0;i<brands.size();i++){
            int counter=0;
            for(Car c:cars)
                if(c!=null&&c.getBrand().equalsIgnoreCase(brands.get(i)))   counter++;
            brands.set(i, brands.get(i)+": "+counter);
        }
        return brands;
    }

    public void restore(String fileName)    throws IOException{
        Car[] temp=new Car[MAX_CARS];
        int i=0;
        Scanner in=new Scanner(new File(fileName));
        while(in.hasNextLine()){
            String[] data=in.nextLine().split(";");
            temp[i++]=new Car(Integer.parseInt(data[0]),Integer.parseInt(data[1]),data[2],data[3]);
        }
        cars=temp;
    }

    public void backup(String fileName)    throws IOException{
        BufferedWriter wr=new BufferedWriter(new FileWriter(fileName));
        for(Car c:cars)
            if(c!=null)     wr.write(c.toString()+"\n");
        wr.close();
    }

    public String toString(){
        return Arrays.toString(cars);
    }
}
