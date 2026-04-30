package dev.bozlak.bbd.dtos.homepage;

import dev.bozlak.bbd.utilities.models.BbdListItemForRemovalDateSection;
import dev.bozlak.bbd.utilities.models.RemovalDateSection;
import dev.bozlak.core.entity.Dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HomePageWholeList  extends Dto {

    private List<BbdListItemForRemovalDateSection> bestBeforeDatePastList;
    private List<RemovalDateSection> removalDateSectionList;
}
