package dev.bozlak.bbd.repository.implementations.jpa.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class RemovalDateSectionForSql {

    private LocalDate removalDate;
    private Long bbdRecordId;
    private String productCode;
    private String productName;
    private Short quantity;
    private LocalDate bestBeforeDate;
    private BigDecimal unitPrice;
    private Short tax;
}
