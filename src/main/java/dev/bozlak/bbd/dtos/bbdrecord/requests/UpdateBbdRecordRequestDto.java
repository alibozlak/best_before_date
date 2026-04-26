package dev.bozlak.bbd.dtos.bbdrecord.requests;

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
public class UpdateBbdRecordRequestDto extends AddBbdRecordRequestDto {

    private Long bbdRecordId;
}
