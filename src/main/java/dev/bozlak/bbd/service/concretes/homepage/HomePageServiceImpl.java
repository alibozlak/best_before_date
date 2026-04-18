package dev.bozlak.bbd.service.concretes.homepage;

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

    @Override
    public List<RemovalDateSection> getCurrentAndSortedBbdList(Integer userId) {
        List<RemovalDateSection> removalDateSections
                = this.homePageRepository.getCurrentBbdList(this.userService.getStoreIdByUserId(userId));

        for(RemovalDateSection removalDateSection : removalDateSections){
            this.sortEachRemovalDateSection(removalDateSection);
        }

        return removalDateSections;
    }

    private void sortEachRemovalDateSection(RemovalDateSection removalDateSection){
        removalDateSection.getProductElementForRemovalDateSections()
                .sort((o1, o2) ->
                        (int) (o1.getAffectInventory() - o2.getAffectInventory())
                );
    }
}
