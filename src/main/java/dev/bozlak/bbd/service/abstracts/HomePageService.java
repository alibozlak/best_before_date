package dev.bozlak.bbd.service.abstracts;

import dev.bozlak.bbd.dtos.homepage.HomePageResponseDto;

public interface HomePageService {

    HomePageResponseDto getHomePageResponseDto(Integer userId);
}
