package dev.bozlak.bbd.service.concretes.homepage;

import dev.bozlak.bbd.dtos.homepage.HomePageHasStoreUserResponseDto;
import dev.bozlak.bbd.dtos.homepage.HomePageResponseDto;
import dev.bozlak.bbd.dtos.homepage.HomePageWholeList;
import dev.bozlak.bbd.dtos.store.HomePageStoreResponseDto;
import dev.bozlak.bbd.repository.baseabstracts.HomePageRepository;
import dev.bozlak.bbd.repository.implementations.jpa.dtos.UserIdStoreAndIsAdminModel;
import dev.bozlak.bbd.service.abstracts.HomePageService;
import dev.bozlak.bbd.service.abstracts.UserService;
import dev.bozlak.bbd.utilities.models.RemovalDateSection;
import lombok.RequiredArgsConstructor;

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
        UserIdStoreAndIsAdminModel userIdStoreAndIsAdminModel
                = this.userService.getUserIdStoreAndIsAdminModel(userId);
        Integer storeId = userIdStoreAndIsAdminModel.getStore().getId();

        if (storeId != 2 && storeId != 3) {
            HomePageStoreResponseDto homePageStoreResponseDto
                    = this.userService.getHomePageStoreResponseDto(userId);

            HomePageWholeList homePageWholeList = this.getCurrentAndSortedBbdList(userId);

            HomePageHasStoreUserResponseDto homePageHasStoreUserResponseDto
                    = new HomePageHasStoreUserResponseDto(homePageStoreResponseDto, homePageWholeList);
            homePageHasStoreUserResponseDto.setUserId(userIdStoreAndIsAdminModel.getUserId());
            homePageHasStoreUserResponseDto.setIsAdmin(userIdStoreAndIsAdminModel.getIsAdmin());
            homePageHasStoreUserResponseDto.setHasStore(true);
            return homePageHasStoreUserResponseDto;
        }

        return new HomePageResponseDto(userId, false, userIdStoreAndIsAdminModel.getIsAdmin());

    }
}
