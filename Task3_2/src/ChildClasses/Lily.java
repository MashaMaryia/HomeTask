package ChildClasses;

import AbstractParentClass.Flowers;
import Enums.FlowerColor;
import Enums.LilyType;
import Exceptions.ColorException;
import Exceptions.LilyTypeException;

public class Lily extends Flowers {

    private LilyType type;

    public Lily(FlowerColor addColor, LilyType type) {
        super(addColor);
        this.type = type;
        price = 20;
    }

    @Override
    public int getPrice() throws LilyTypeException,ColorException{
        if (color == FlowerColor.WHITE||color == FlowerColor.YELLOW||color == FlowerColor.PINK){

            switch (type){
                case ASIATIC: price=price;
                break;
                case AMERICAN: price= (int) (1.5*price);
                break;
                case LONGIFLORUM: price = (int) (2*price);
                break;
            default:
                price=0;
                throw new LilyTypeException("Selected type is not in inventory.We have only lilies of the following types: asiatic, american and longiflorum");
        }}

        else {price=0;
            throw new ColorException("Selected color is not in inventory. We have only lilies of the following colors: white, yellow and pink");
            }
        return price;
    }

    @Override
    public String getName() {
        return "lily";
    }

    public void setType(LilyType type)
    {
        this.type = type;
    }

    public LilyType getType()
    {
        return this.type;
    }


}
