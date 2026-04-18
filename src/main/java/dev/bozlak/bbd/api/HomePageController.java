package dev.bozlak.bbd.api;

import dev.bozlak.bbd.service.abstracts.HomePageService;
import dev.bozlak.bbd.utilities.dtos.RemovalDateSection;
import dev.bozlak.core.responses.ResponseBodyWithObject;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/homepage")
@RequiredArgsConstructor
public class HomePageController {

    private final HomePageService homePageService;

    @GetMapping("/get-bbd-list-by-user-id/{userId}")
    public ResponseBodyWithObject<List<RemovalDateSection>> getBbdListByUserId(@PathVariable("userId") Integer userId){
        return new ResponseBodyWithObject<>(this.homePageService.getCurrentAndSortedBbdList(userId));
    }
}
