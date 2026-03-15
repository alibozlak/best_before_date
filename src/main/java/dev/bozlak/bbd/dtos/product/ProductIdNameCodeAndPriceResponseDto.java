package dev.bozlak.bbd.dtos.product;

import dev.bozlak.core.entity.Dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductIdNameCodeAndPriceResponseDto extends Dto {

    private Integer id;
    private String productName;
    private String productCode;
    private BigDecimal price;
}
