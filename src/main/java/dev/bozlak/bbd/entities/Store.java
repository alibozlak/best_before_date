package dev.bozlak.bbd.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Store extends dev.bozlak.core.entity.Entity {

    private Integer id;
    private String storeName;
    private String storeCode;
}
