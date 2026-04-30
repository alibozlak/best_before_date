package dev.bozlak.bbd.utilities.models.useractivity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddUserActivityModel {

    private Integer userId;
    private Long bbdRecordId;
    private Short quantity;
    private Byte activityTypeId;
}
