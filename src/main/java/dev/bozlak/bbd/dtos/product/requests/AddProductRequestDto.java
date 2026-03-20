package dev.bozlak.bbd.dtos.product.requests;

import dev.bozlak.core.entity.Dto;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class AddProductRequestDto extends Dto {

    @NotNull(message = "Product name must be not null!!")
    @NotBlank(message = "Product name must be not blank!!")
    private String productName;

    @Size(min = 7, max = 7)
    private String productCode;

    @Min(value = 0)
    @NotNull(message = "Best Before Date must be not null!!")
    private Short bestBefore;

    @Min(value = 0)
    private BigDecimal price;

    @Positive
    @Max(value = 100)
    private Short tax;
}
