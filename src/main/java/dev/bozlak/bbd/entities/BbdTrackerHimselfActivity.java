package dev.bozlak.bbd.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BbdTrackerHimselfActivity {

    private Long id;
    private Integer bbdTrackerId;
    private Byte activityTypeId;
    private Integer addedOrDeletedUserId;
}
