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
public class BbdRecordWithoutRemovalDateResponse {

    private Long id;
    private Integer productId;
    private LocalDate bestBeforeDate;
    private Short quantity;
}
