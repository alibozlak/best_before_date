package dev.bozlak.bbd.dtos.bbdrecord.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EditBbdRecordPageResponseDto extends BbdRecordWithoutRemovalDateResponse {

    private String productName;

    public EditBbdRecordPageResponseDto(
            BbdRecordWithoutRemovalDateResponse bbdRecordWithoutRemovalDateResponse,
            String productName
    ){
        super(bbdRecordWithoutRemovalDateResponse.getId(),
                bbdRecordWithoutRemovalDateResponse.getProductId(),
                bbdRecordWithoutRemovalDateResponse.getBestBeforeDate(),
                bbdRecordWithoutRemovalDateResponse.getQuantity()
        );
        this.productName = productName;
    }
}
