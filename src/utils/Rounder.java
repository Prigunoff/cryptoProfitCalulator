package utils;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Rounder {
    // Округление значения по шаблону

    public static double roundDownTokens(double d) {
        return Math.floor(d * 1e5) / 1e5;
    }

    public static String roundValueProfit(double value) {
        return new DecimalFormat("0.00").format(value);
    }
}
