package dev.bozlak.bbd.repository.implementations.jpa.homepage;

import dev.bozlak.bbd.repository.baseabstracts.HomePageRepository;
import dev.bozlak.bbd.utilities.dtos.BbdListItemForRemovalDateSection;
import dev.bozlak.bbd.utilities.dtos.RemovalDateSection;
import dev.bozlak.bbd.utilities.dtos.RemovalDateSectionForSql;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@RequiredArgsConstructor
public class JpaHomePageRepositoryAdapter implements HomePageRepository {

    private final JpaHomePageRepository jpaHomePageRepository;

    @Override
    public List<RemovalDateSection> getCurrentBbdList(Integer storeId) {
        LocalDate today = LocalDate.now();
        List<RemovalDateSectionForSql> listOfRemovalDateSectionForSql
                = this.jpaHomePageRepository.getCurrentBbdList(today, storeId);

        List<RemovalDateSection> listForHomePage = new ArrayList<>();
        listForHomePage.add(new RemovalDateSection());
        listForHomePage.getFirst().setRemovalDate(listOfRemovalDateSectionForSql.getFirst().getRemovalDate());

        for (RemovalDateSectionForSql removalDateSectionForSql : listOfRemovalDateSectionForSql) {
            for (int i = 0; i < listForHomePage.size(); i++) {
                if (removalDateSectionForSql.getRemovalDate().compareTo(listForHomePage.get(i).getRemovalDate()) == 0) {
                    this.addBbdListItemToListInRemovalDateSection(listForHomePage.get(i), removalDateSectionForSql);
                } else {
                    listForHomePage.add(new RemovalDateSection(
                            removalDateSectionForSql.getRemovalDate(), new ArrayList<>()
                    ));

                    this.addBbdListItemToListInRemovalDateSection(listForHomePage.getLast(), removalDateSectionForSql);
                }
            }
        }

        return listForHomePage;
    }

    private void addBbdListItemToListInRemovalDateSection(
            RemovalDateSection removalDateSection, RemovalDateSectionForSql removalDateSectionForSql
    ){
        removalDateSection.getProductElementForRemovalDateSections().add(
                new BbdListItemForRemovalDateSection(
                        removalDateSectionForSql.getBbdRecordId(),
                        removalDateSectionForSql.getProductCode(),
                        removalDateSectionForSql.getProductName(),
                        removalDateSectionForSql.getQuantity(),
                        removalDateSectionForSql.getBestBeforeDate(),
                        removalDateSectionForSql.getUnitPrice(),
                        removalDateSectionForSql.getTax(),
                        removalDateSectionForSql.getUnitPrice() *
                                (1 - removalDateSectionForSql.getTax()/100) *
                                removalDateSectionForSql.getQuantity() * (-1)
                )
        );
    }
}
