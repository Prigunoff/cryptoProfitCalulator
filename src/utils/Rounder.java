package utils;

import java.text.DecimalFormat;

public class Rounder {
    // Округление значения по шаблону
    public static String roundValue(double value) {
        return new DecimalFormat("0.00").format(value);
    }
}
