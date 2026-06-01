package dev.bozlak.bbd.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdminStoreActivity {

    private Integer id;
    private Integer adminId;
    private Integer storeId;
    private Byte activityTypeId;
}
