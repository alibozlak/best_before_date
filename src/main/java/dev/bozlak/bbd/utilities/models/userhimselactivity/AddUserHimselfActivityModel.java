package dev.bozlak.bbd.utilities.models.userhimselactivity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AddUserHimselfActivityModel {

    private Integer userId;
    private Byte activityTypeId;
}
