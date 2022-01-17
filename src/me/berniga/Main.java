package me.berniga;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author : Christian Berniga
 * @class : 4 D
 * @created : 17/01/2022, lunedì
 **/
public class Main {

    public static void main(String[] args) {
        Renthal r=new Renthal();
        try{
            Scanner scan=new Scanner(new File("in.txt"));
            while(scan.hasNextLine()){
                String[] data=scan.nextLine().split(";");
                r.addCar(new Car(Integer.parseInt(data[0]),data[1],data[2]));
            }
        }catch(IOException e){System.out.println(e);}

        //System.out.println(r.toString());

        try{
            r.removeCar("00");
            r.removeCar(100);
        }catch (CarNotFoundException e){System.out.println(e);}

        try{
            System.out.println(r.getCarInfo(1));
            System.out.println(r.getCarInfo("100"));
        }catch (CarNotFoundException e){System.out.println(e);}

        try{
            System.out.println(r.getCarsBySeats(4));
        }catch (CarNotFoundException e){System.out.println(e);}


        try{
            System.out.println(r.carByBrand());
        }catch(CarNotFoundException e){System.out.println(e);}

        try{
            r.backup("out.txt");
        }catch (IOException e){System.out.println(e);}

    }
}
