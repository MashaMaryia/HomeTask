package Comparator;

import AbstractParentClass.Flowers;

import java.util.Comparator;

public class MyComparator1 implements Comparator<Flowers> {

    @Override
    public int compare(Flowers o1, Flowers o2) {

        String name1 = o1.getName();
        String name2 = o2.getName();

        return name2.compareTo(name1);
    }
}
