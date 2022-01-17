package me.berniga;

/**
 * @author : Christian Berniga
 * @class : 4 D
 * @created : 17/01/2022, lunedì
 **/
public class CarNotFoundException extends Exception{
    public CarNotFoundException(){super();}

    public String toString(){
        return "Sorry! The car you are looking for is not in this renthal or there are no cars with the searched specs";
    }
}
