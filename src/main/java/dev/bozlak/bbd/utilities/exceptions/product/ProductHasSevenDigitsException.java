package dev.bozlak.bbd.utilities.exceptions.product;

public class ProductHasSevenDigitsException extends RuntimeException {

    public ProductHasSevenDigitsException(){
        super("Product Code must be 7 digits!!");
    }
}
