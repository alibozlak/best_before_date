package dev.bozlak.bbd.utilities;

public class StringUtility {

    public static boolean isStringNotNullAndNotEmpty(String string){
        return string != null && !string.isBlank();
    }
}
