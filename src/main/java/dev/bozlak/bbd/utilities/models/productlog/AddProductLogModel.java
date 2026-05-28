package dev.bozlak.bbd.utilities.models.productlog;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddProductLogModel {

    private Integer bbdTrackerId;
    private Integer userId;
    private Byte activityTypeId;
}
