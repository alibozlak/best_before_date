package dev.bozlak.bbd.utilities;

public class ProductUtility {
    public static boolean hasProductCodeSevenDigits(String productCode){
        return productCode.length() == 7;
    }
}
