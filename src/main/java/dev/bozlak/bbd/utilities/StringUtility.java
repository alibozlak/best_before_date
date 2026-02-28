package dev.bozlak.bbd.utilities;

public class StringUtility {

    public static boolean isStringNotNullAndNotEmpty(String string){
        return string != null && !string.isBlank();
    }

    public static void ifStringNullOrEmptyThrowException(String stringForChecking, String stringForMessage){
        if (!isStringNotNullAndNotEmpty(stringForChecking))
            throw new RuntimeException(stringForMessage + " must be not null or empty!!");
    }
}
