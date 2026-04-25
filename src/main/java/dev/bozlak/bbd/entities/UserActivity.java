package dev.bozlak.bbd.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserActivity extends dev.bozlak.core.entity.Entity {

    private Long id;
    private Integer userId;
    private Long bbdRecordId;
    private LocalDateTime addedDateTime;
    private Short quantity;
    private Byte activityTypeId;
    private String activityNote;
}
