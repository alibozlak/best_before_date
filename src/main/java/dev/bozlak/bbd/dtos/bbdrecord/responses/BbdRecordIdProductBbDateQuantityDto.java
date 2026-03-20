package dev.bozlak.bbd.dtos.bbdrecord.responses;

import dev.bozlak.bbd.dtos.product.responses.ProductIdNameCodeAndPriceResponseDto;
import dev.bozlak.core.entity.Dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BbdRecordIdProductBbDateQuantityDto extends Dto {

    private Long id;
    private ProductIdNameCodeAndPriceResponseDto productIdNameCodeAndPriceResponseDto;
    private LocalDate bestBeforeDate;
    private Short quantity;
}
