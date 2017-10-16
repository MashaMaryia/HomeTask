package MyInterface;

import Exceptions.ColorException;
import Exceptions.HeightException;
import Exceptions.LilyTypeException;

public interface Goods {
    public void setPrice(int price);
    public int getPrice()throws ColorException, LilyTypeException, HeightException;
}

