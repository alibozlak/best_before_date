package dev.bozlak.bbd.dtos.forupdatebbdrecordpage;

import dev.bozlak.bbd.dtos.bbdrecord.responses.BbdRecordWithoutRemovalDateResponse;
import dev.bozlak.bbd.dtos.product.responses.ProductIdNameCodeAndPriceResponseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBbdRecordPageResponseDto {

    private BbdRecordWithoutRemovalDateResponse bbdRecordWithoutRemovalDateResponse;
    private List<ProductIdNameCodeAndPriceResponseDto> productIdNameCodeAndPriceResponseDtoList;
}
