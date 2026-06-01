package dev.bozlak.bbd.utilities.models.adminstoreactivity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddAdminStoreActivityModel {

    private Integer adminId;
    private Integer storeId;
    private Byte activityTypeId;
}
