package ChildClasses;

import AbstractParentClass.Flowers;
import Enums.FlowerColor;
import Exceptions.ColorException;

public class Tulip extends Flowers {

    public Tulip(FlowerColor addColor) {
        super(addColor);
        price=5;
    }

    @Override
    public int getPrice()throws ColorException {
        switch (getColor()){
            case RED: price=price;
            break;
            case YELLOW: price= (int) (1.2*price);
            break;
            case WHITE: price = (int) (1.2*price);
            break;
            case VIOLET: price = (int) (1.5*price);
            break;
            case BLACK: price = (int)(2*price);
            break;
            default:
                price=0;
                throw new ColorException("Selected color is not in inventory. We have only tulips of the following colors: red, yellow, white, violet, black");
        }
        return price;
    }

    public String getName(){
        return "tulip";
    }
}
