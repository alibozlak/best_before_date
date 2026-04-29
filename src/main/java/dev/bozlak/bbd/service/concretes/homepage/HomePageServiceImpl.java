package dev.bozlak.bbd.service.concretes.homepage;

import dev.bozlak.bbd.dtos.homepage.HomePageResponseDto;
import dev.bozlak.bbd.dtos.homepage.HomePageWholeList;
import dev.bozlak.bbd.dtos.store.HomePageStoreResponseDto;
import dev.bozlak.bbd.repository.baseabstracts.HomePageRepository;
import dev.bozlak.bbd.service.abstracts.HomePageService;
import dev.bozlak.bbd.service.abstracts.UserService;
import dev.bozlak.bbd.utilities.dtos.RemovalDateSection;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class HomePageServiceImpl implements HomePageService {

    private final HomePageRepository homePageRepository;
    private final UserService userService;

    private HomePageWholeList getCurrentAndSortedBbdList(Integer userId) {
        HomePageWholeList homePageWholeList
                = this.homePageRepository.getCurrentBbdList(this.userService.getStoreIdByUserId(userId));

        for(RemovalDateSection removalDateSection : homePageWholeList.getRemovalDateSectionList()){
            this.sortEachRemovalDateSection(removalDateSection);
        }

        return homePageWholeList;
    }

    private void sortEachRemovalDateSection(RemovalDateSection removalDateSection){
        removalDateSection.getProductElementForRemovalDateSections()
                .sort((o1, o2) ->
                        (int) (o1.getAffectInventory() - o2.getAffectInventory())
                );
    }

    @Override
    public HomePageResponseDto getHomePageResponseDto(Integer userId) {
        HomePageStoreResponseDto homePageStoreResponseDto
                = this.userService.getHomePageStoreResponseDto(userId);

        HomePageWholeList homePageWholeList = this.getCurrentAndSortedBbdList(userId);

        return new HomePageResponseDto(homePageStoreResponseDto, homePageWholeList);
    }
}
