package dev.bozlak.bbd.dtos.store;

import dev.bozlak.core.entity.Dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HomePageStoreResponseDto extends Dto {

    private Integer storeId;
    private String storeName;
    private String storeCode;
}
