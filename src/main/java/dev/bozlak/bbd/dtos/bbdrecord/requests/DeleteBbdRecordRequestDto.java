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
public class DeleteBbdRecordRequestDto extends Dto {

    private Long bbdRecordId;

    private Integer userId;
    private Short quantity;
    private Byte activityTypeId;
}
