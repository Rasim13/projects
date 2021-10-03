package OOP4;

import java.util.Random;

public class Rose extends Flower {

    enum Country {
        Голландия,
        Россия,
        Германия,
        Франция
    };


    public Rose(String manufacturerCountry, int shelfLife, int price) {
        super(manufacturerCountry, shelfLife, price);
    }

    public void createRose() {
        Country[] values = Country.values();
        int length = values.length;
        Country c1 = values[0];

//        Rose rose = new Rose(index, 10, 4500);
    }

    private int getCountry() {
        Country[] values = Country.values();
        int length = values.length;
        int index = new Random().nextInt(length);
        return index;
    }
}
