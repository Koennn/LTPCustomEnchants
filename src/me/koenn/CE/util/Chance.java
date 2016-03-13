package me.koenn.CE.util;

import java.util.Random;

/**
 * Some chance related stuff.
 */
public class Chance {

    public static boolean chanceOf(int percentage) {
        if (percentage > 100 || percentage < 1) {
            throw new IndexOutOfBoundsException("Illegal percentage '" + percentage + "'");
        }
        Random random = new Random();
        return random.nextInt(100) < percentage;
    }
}
