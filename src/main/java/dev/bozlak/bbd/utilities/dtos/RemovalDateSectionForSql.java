package dev.bozlak.bbd.utilities.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RemovalDateSectionForSql {

    private LocalDate removalDate;
    private Long bbdRecordId;
    private String productCode;
    private String productName;
    private Short quantity;
    private LocalDate bestBeforeDate;
    private Double unitPrice;
    private Short tax;
}
