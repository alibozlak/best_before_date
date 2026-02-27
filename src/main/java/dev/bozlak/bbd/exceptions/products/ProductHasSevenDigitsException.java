package dev.bozlak.bbd.exceptions.products;

public class ProductHasSevenDigitsException extends RuntimeException {

    public ProductHasSevenDigitsException(){
        super("Product Code must be 7 digits!!");
    }
}
