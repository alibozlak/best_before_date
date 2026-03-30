package dev.bozlak.bbd.repository.implementations.jpa.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String productName;

    @Column(length = 7)
    private String productCode;

    private Short bestBefore;

    private BigDecimal price;

    private Short tax;

    //--------------Constructor(s)-------------

    public Product(Integer productId){
        this.setId(productId);
    }
}