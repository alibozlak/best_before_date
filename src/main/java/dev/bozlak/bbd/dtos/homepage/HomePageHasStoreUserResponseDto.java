package dev.bozlak.bbd.dtos.homepage;

import dev.bozlak.bbd.dtos.store.HomePageStoreResponseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class HomePageHasStoreUserResponseDto extends HomePageResponseDto {

    private HomePageStoreResponseDto homePageStoreResponseDto;
    private HomePageWholeList homePageWholeList;
}
