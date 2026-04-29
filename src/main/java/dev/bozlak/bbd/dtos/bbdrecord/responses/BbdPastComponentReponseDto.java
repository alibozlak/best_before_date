package dev.bozlak.bbd.dtos.bbdrecord.responses;

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
public class BbdPastComponentReponseDto extends Dto {

    private Long bbdRecordId;
    private String productName;
    private String productCode;
    private Short quantity;
    private LocalDate bestBeforeDate;
}
