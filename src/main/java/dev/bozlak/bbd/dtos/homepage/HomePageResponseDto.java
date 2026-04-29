package dev.bozlak.bbd.dtos.homepage;

import dev.bozlak.bbd.dtos.store.HomePageStoreResponseDto;
import dev.bozlak.core.entity.Dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HomePageResponseDto extends Dto {

    private HomePageStoreResponseDto homePageStoreResponseDto;
    private HomePageWholeList homePageWholeList;
}
