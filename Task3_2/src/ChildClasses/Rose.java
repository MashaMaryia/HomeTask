package ChildClasses;

import AbstractParentClass.Flowers;
import Enums.FlowerColor;
import Exceptions.ColorException;
import Exceptions.HeightException;

public class Rose extends Flowers {

    public Rose(FlowerColor addColor, double addHeight) {
        super(addColor,addHeight);
        price = 10;
    }

    public int getPrice() throws ColorException,HeightException, ArithmeticException {

        if (color == FlowerColor.RED||color==FlowerColor.WHITE||color==FlowerColor.YELLOW){
            price = price;
        }
        else {
            price=0;
            throw new ColorException("Selected color is not in inventory. We have only roses of the following colors: red, yellow, white");
            }

        if(height < 40 && height >= 25){
         price = price;
        }
        else {
            if (height >=40 & height < 70){
                price = (int) (1.5*price); }
            else {
                price = 2*price;
            }
        }

        if(height < 25 && height > 0) {
            price=0;
            throw new HeightException("We don't have roses with height less than 25cm");
        }

        if(height<=0){
            price=0;
            throw new ArithmeticException("A height can not be zero or a negative value");
        }

        return price;
    }



    public String getName(){

        return "rose";
    }

}