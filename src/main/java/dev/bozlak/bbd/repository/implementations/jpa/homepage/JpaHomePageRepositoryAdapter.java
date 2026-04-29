package dev.bozlak.bbd.repository.implementations.jpa.homepage;

import dev.bozlak.bbd.dtos.homepage.HomePageWholeList;
import dev.bozlak.bbd.repository.baseabstracts.HomePageRepository;
import dev.bozlak.bbd.utilities.dtos.BbdListItemForRemovalDateSection;
import dev.bozlak.bbd.utilities.dtos.RemovalDateSection;
import dev.bozlak.bbd.repository.implementations.jpa.dtos.RemovalDateSectionForSql;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
public class JpaHomePageRepositoryAdapter implements HomePageRepository {

    private final JpaHomePageRepository jpaHomePageRepository;

    @Override
    public HomePageWholeList getCurrentBbdList(Integer storeId) {
        List<RemovalDateSectionForSql> listOfRemovalDateSectionForSql
                = this.jpaHomePageRepository.getCurrentBbdList(storeId);

        List<RemovalDateSection> listForHomePage = new ArrayList<>();
        List<BbdListItemForRemovalDateSection> bestBeforeDatePastList = new ArrayList<>();
        Set<LocalDate> removalDates = new HashSet<>();

        //FixMe
        listOfRemovalDateSectionForSql.forEach(rdsfs -> {
            if (rdsfs.getBestBeforeDate().isBefore(LocalDate.now())){
                this.addBbdToBbdListItemForRemovalDateSectionList(bestBeforeDatePastList, rdsfs);
            } else if (removalDates.contains(rdsfs.getRemovalDate())){
                RemovalDateSection removalDateSection
                        = listForHomePage.stream().filter(rds ->
                            rds.getRemovalDate().equals(rdsfs.getRemovalDate())).findFirst().get();

                this.addBbdToRemovalDateSection(rdsfs, removalDateSection);
            } else {
                removalDates.add(rdsfs.getRemovalDate());

                listForHomePage.add(new RemovalDateSection());
                listForHomePage.getLast().setRemovalDate(rdsfs.getRemovalDate());
                listForHomePage.getLast().setProductElementForRemovalDateSections(new ArrayList<>());

                this.addBbdToRemovalDateSection(rdsfs, listForHomePage.getLast());
            }
        });

        return new HomePageWholeList(bestBeforeDatePastList, listForHomePage);
    }

    private void addBbdToRemovalDateSection(
            RemovalDateSectionForSql removalDateSectionForSql, RemovalDateSection removalDateSection
    ){
        this.addBbdToBbdListItemForRemovalDateSectionList(
                removalDateSection.getProductElementForRemovalDateSections(), removalDateSectionForSql
        );
    }

    private void addBbdToBbdListItemForRemovalDateSectionList(
            List<BbdListItemForRemovalDateSection> listOfBbdListItemForRemovalDateSection,
            RemovalDateSectionForSql removalDateSectionForSql
    ){
        listOfBbdListItemForRemovalDateSection.add(new BbdListItemForRemovalDateSection(
                removalDateSectionForSql.getBbdRecordId(),
                removalDateSectionForSql.getProductCode(),
                removalDateSectionForSql.getProductName(),
                removalDateSectionForSql.getQuantity(),
                removalDateSectionForSql.getBestBeforeDate(),
                removalDateSectionForSql.getUnitPrice().doubleValue(),
                removalDateSectionForSql.getTax(),
                Math.round(removalDateSectionForSql.getUnitPrice().doubleValue() *
                        (1 - removalDateSectionForSql.getTax().doubleValue()/100.0) *
                        removalDateSectionForSql.getQuantity() * (-1)
                )
        ));
    }
}
