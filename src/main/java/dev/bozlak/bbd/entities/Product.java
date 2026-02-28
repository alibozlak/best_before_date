package dev.bozlak.bbd.entities;

import dev.bozlak.bbd.exceptions.products.ProductHasSevenDigitsException;
import dev.bozlak.bbd.utilities.ProductUtility;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "products")
@Getter
@Setter
public class Product extends dev.bozlak.core.entity.Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String productName;

    @Column(length = 7)
    private String productCode;

    private Short bestBefore;

    private BigDecimal price;

    private Short tax;


    //--------------Setters-------------

    public void setProductCode(String productCode) {
        if (!ProductUtility.hasProductCodeSevenDigits(productCode))
            throw new ProductHasSevenDigitsException();
        this.productCode = productCode;
    }
}
