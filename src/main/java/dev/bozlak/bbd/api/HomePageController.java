package dev.bozlak.bbd.api;

import dev.bozlak.bbd.dtos.homepage.HomePageResponseDto;
import dev.bozlak.bbd.service.abstracts.HomePageService;
import dev.bozlak.core.responses.ResponseBodyWithObject;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/homepage")
@RequiredArgsConstructor
@Tag(name = "Home Page Data", description = "Endpoints for fetching dashboard and home page aggregates.")
public class HomePageController {

    private final HomePageService homePageService;

    @GetMapping("/get-whole-data-for-home-page/{userId}")
    @Operation(
            summary = "Get Dashboard Data",
            description = "Retrieves the complete BBD list, removal dates, and store information for the given user ID."
    )
    public ResponseEntity<ResponseBodyWithObject<HomePageResponseDto>> getBbdListByUserId(@PathVariable("userId") Integer userId){
        HomePageResponseDto homePageResponseDto = this.homePageService.getHomePageResponseDto(userId);

        return new ResponseEntity<>(
                new ResponseBodyWithObject<>(homePageResponseDto),
                HttpStatus.OK
        );
    }

}
