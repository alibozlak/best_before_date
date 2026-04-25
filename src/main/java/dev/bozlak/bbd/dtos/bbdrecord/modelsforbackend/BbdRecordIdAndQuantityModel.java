package dev.bozlak.bbd.dtos.bbdrecord.modelsforbackend;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BbdRecordIdAndQuantityModel {
    private Long bbdRecordId;
    private Short newQuantity;
}
