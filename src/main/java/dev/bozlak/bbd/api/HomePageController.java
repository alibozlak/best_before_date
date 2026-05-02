package dev.bozlak.bbd.api;

import dev.bozlak.bbd.dtos.homepage.HomePageResponseDto;
import dev.bozlak.bbd.service.abstracts.HomePageService;
import dev.bozlak.core.responses.ResponseBodyWithObject;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/homepage")
@RequiredArgsConstructor
public class HomePageController {

    private final HomePageService homePageService;

    @GetMapping("/get-whole-data-for-home-page/{userId}")
    public ResponseBodyWithObject<HomePageResponseDto> getBbdListByUserId(@PathVariable("userId") Integer userId){
        HomePageResponseDto homePageResponseDto = this.homePageService.getHomePageResponseDto(userId);
        return new ResponseBodyWithObject<>(homePageResponseDto);
    }

}
