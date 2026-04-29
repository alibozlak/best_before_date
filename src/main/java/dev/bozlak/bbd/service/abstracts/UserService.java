package dev.bozlak.bbd.service.abstracts;

import dev.bozlak.bbd.dtos.store.HomePageStoreResponseDto;
import dev.bozlak.bbd.dtos.user.AddUserRequestDto;

public interface UserService {

    void add(AddUserRequestDto addUserRequestDto);
    boolean doesExistUserIdGivenNumber(Integer userId);
    void deleteUserById(Integer id);
    Integer getUserIdByUsername(String username);
    Integer getStoreIdByUserId(Integer userId);
    HomePageStoreResponseDto getHomePageStoreResponseDto(Integer userId);
}
