package utils;

/**
 * Created by german on 10/14/2016.
 */
public class StringToIntConverter {
    public static int parseWithDefault(String number, int defaultVal) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            return defaultVal;
        }
    }
}
