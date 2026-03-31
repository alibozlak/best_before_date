package dev.bozlak.bbd.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BbdRecord extends dev.bozlak.core.entity.Entity {

    private Long id;
    private Integer userId;
    private Integer storeId;
    private Integer productId;
    private LocalDate bestBeforeDate;
    private Short quantity;
}
