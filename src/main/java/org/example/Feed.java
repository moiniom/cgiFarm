package org.example;

import java.util.HashMap;

public class Feed {
    public enum type {
        SEEDS,
        WHEAT,
        STEAK,
        CARROT,
        PENGUIN
    }

    private static final HashMap<type, Integer> price = new HashMap<>();
    static {
        price.put(type.SEEDS, 10);
        price.put(type.WHEAT, 20);
        price.put(type.STEAK, 30);
        price.put(type.CARROT, 20);
        price.put(type.PENGUIN, 40);
    }

    private static final HashMap<type, String> name = new HashMap<>();
    static {
        name.put(type.SEEDS, "seeds");
        name.put(type.WHEAT, "wheat");
        name.put(type.STEAK, "steak");
        name.put(type.CARROT, "carrot");
        name.put(type.PENGUIN, "penguin");
    }

    public static int getPrice(type type) {
        return price.get(type);
    }

    public static String getName(type type) {
        return name.get(type);
    }
}
