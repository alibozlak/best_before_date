package dev.bozlak.bbd.repository.implementations.jpa.homepage;

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
    public List<RemovalDateSection> getCurrentBbdList(Integer storeId) {
        LocalDate today = LocalDate.now();
        List<RemovalDateSectionForSql> listOfRemovalDateSectionForSql
                = this.jpaHomePageRepository.getCurrentBbdList(today, storeId);

        List<RemovalDateSection> listForHomePage = new ArrayList<>(listOfRemovalDateSectionForSql.size());
        Set<LocalDate> removalDates = new HashSet<>();

        //FixMe
        listOfRemovalDateSectionForSql.forEach(rdsfs -> {
            if (removalDates.contains(rdsfs.getRemovalDate())){
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

        return listForHomePage;
    }

    private void addBbdToRemovalDateSection(
            RemovalDateSectionForSql removalDateSectionForSql, RemovalDateSection removalDateSection
    ){
        removalDateSection.getProductElementForRemovalDateSections().add(new BbdListItemForRemovalDateSection(
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
