package dev.bozlak.bbd.dtos.bbdrecord.requests;

import dev.bozlak.bbd.utilities.models.useractivity.AddUserActivityModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SaleProductRequestDto extends AddUserActivityModel {

    private Short newQuantity;

    @Override
    public String toString() {
        return "{bbdRecordId : " + this.getBbdRecordId() +
                ", userId : " + this.getUserId() +
                ", newQuantity : " + newQuantity +
                ", saledQuantity : " + this.getQuantity() +
                ", activityTypeId : " + this.getActivityTypeId() + "}";
    }
}
