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
public class BbdPastComponentRequestDto extends Dto {

    private Integer userId;
    private Byte activityTypeId;

    private Long bbdRecordId;
    private Short deletedQuantity;
}
