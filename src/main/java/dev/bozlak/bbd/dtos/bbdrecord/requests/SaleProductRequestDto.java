package dev.bozlak.bbd.dtos.bbdrecord.requests;

import dev.bozlak.core.entity.Dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SaleProductRequestDto extends Dto {
    private Long bbdRecordId;
    private Short newQuantity;
    private Short saledQuantity;
    private Integer userId;
    private Byte activityTypeId;

    @Override
    public String toString() {
        return "{bbdRecordId : " + bbdRecordId +
                ", userId : " + userId +
                ", newQuantity : " + newQuantity +
                ", saledQuantity : " + saledQuantity +
                ", activityTypeId : " + activityTypeId + "}";
    }
}
