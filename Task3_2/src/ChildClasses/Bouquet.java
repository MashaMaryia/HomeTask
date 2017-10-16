package ChildClasses;

import AbstractParentClass.Flowers;
import Enums.FlowerColor;
import Enums.LilyType;
import Exceptions.ColorException;
import Exceptions.FlowerKindException;
import Exceptions.HeightException;
import Exceptions.LilyTypeException;

import java.io.*;
import java.util.Map;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;


public class Bouquet {
    public static Double getDouble(String s){
        try{
            return Double.parseDouble(s);
        } catch (Exception e){
            return null;
        }
    }
    public static void main (String[] args) throws IOException {
        ArrayList<Flowers> bouquet = new ArrayList<Flowers>();
        File file = new File("flower.txt");
        String line = "";
        String item1, item2, item3 = null;;

        if(file.exists()){
            try {
                BufferedReader f = new BufferedReader(new FileReader(file));
                while ((line = f.readLine()) != null) {
                    FlowerColor color = null;
                    Double height = null;
                    LilyType type = null;
                try{
                    String[] value = line.split(", ");
                    item1 = value[0].toLowerCase();
                    item2 = value[1].toUpperCase();
                    color = FlowerColor.valueOf(item2);

                    if (value.length == 3) {
                        item3 = value[2];
                        height = Bouquet.getDouble(item3);
                        if (height == null) {
                            type = LilyType.valueOf(item3.toUpperCase());
                        }
                    }

                    if (item1.equals("rose")) {
                        bouquet.add(new Rose(color, height));
                    } else {
                        if (item1.equals("tulip")) {
                            bouquet.add(new Tulip(color));
                        } else {
                            if (item1.equals("lily")) {
                                bouquet.add(new Lily(color, type));
                            } else {
                                throw new FlowerKindException("Unknown kind of a flower.");
                            }
                        }
                    }}
                catch(FlowerKindException e){
                    e.printStackTrace();
                }
                catch(NullPointerException e){
                    e.printStackTrace();
                }
                catch(IllegalArgumentException e){
                    e.printStackTrace();
                }
                catch(ArrayIndexOutOfBoundsException e){
                    e.printStackTrace();
                }
                }
                f.close();
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }

        else {
            throw new RuntimeException("The file doesn't exist");
        }

        int sum=0;

            HashMap<String, Integer> flowerType = new HashMap<String, Integer>();

             for(int i=0; i<bouquet.size(); i++) {
                 int cost = 0;
                 try {
                     cost = bouquet.get(i).getPrice();
                 } catch (ArithmeticException e) {
                     e.printStackTrace();
                 }
                 catch (ColorException e) {
                     e.printStackTrace();
                 }
                 catch (HeightException e) {
                     e.printStackTrace();
                 }
                 catch (LilyTypeException e) {
                     e.printStackTrace();
                 }
                 String kind = bouquet.get(i).getName();

                 sum = sum + cost;

                 if (cost == 0) {
                     bouquet.remove(i);
                     i--;
                 }
                 else {
                     if (!flowerType.containsKey(kind)) {
                         flowerType.put(kind, 1);
                     } else {
                         int j = flowerType.get(kind);
                         flowerType.put(kind, ++j);
                     }
                 }
             }
        File file2 = new File("bouquet.txt");
        boolean createFile = file2.createNewFile();
        PrintWriter writeToFile = new PrintWriter(new FileWriter(file2));
        writeToFile.printf ("\nYour bouquet consists of %d flowers, where: ", bouquet.size());

        Set set =flowerType.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            Map.Entry m = (Map.Entry) iterator.next();
            writeToFile.print("\n"+m.getKey()+" - "+m.getValue());
        }

        Collections.sort(bouquet, new Comparator.MyComparator1());
        writeToFile.print("\n\nDetails:"  );
        for(int i=0; i<bouquet.size(); i++){
            writeToFile.print("\n"+bouquet.get(i).getName()+ "\t" + bouquet.get(i).getColor());
        }

        writeToFile.printf("%n%nThe cost of the bouquet is %d rubles %n", sum);
        writeToFile.close();
    }
}
