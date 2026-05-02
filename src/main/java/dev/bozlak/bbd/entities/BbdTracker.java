package dev.bozlak.bbd.entities;

import dev.bozlak.core.entity.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BbdTracker extends Entity {

    private Integer id;
    private Integer userId;
    private String noteForTracker;
}
