package AbstractParentClass;

import Enums.FlowerColor;
import Exceptions.ColorException;
import Exceptions.HeightException;
import Exceptions.LilyTypeException;
import MyInterface.Goods;

public abstract class Flowers implements Goods {

    protected int price;
    protected FlowerColor color;
    protected double height;

    public Flowers (FlowerColor addColor, double addHeight) {
        color = addColor;
        height = addHeight;
    }

    public Flowers(FlowerColor addColor) {
        color = addColor;
    }

    @Override
    public void setPrice(int newPrice) {
        price = newPrice;
    }

    public abstract int getPrice() throws LilyTypeException, ColorException, HeightException;

    public abstract String getName();


    public void setColor(FlowerColor newColor) {
        color = newColor;
    }

    public FlowerColor getColor() {
        return color; }

    public void setHeight(double newHeight) {
        height = newHeight; }

    public double getHeight () {
        return height; }
}