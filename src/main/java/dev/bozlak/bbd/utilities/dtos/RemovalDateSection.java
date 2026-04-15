package dev.bozlak.bbd.utilities.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RemovalDateSection {

    private LocalDate removalDate;
    private List<BbdListItemForRemovalDateSection> productElementForRemovalDateSections;
}
