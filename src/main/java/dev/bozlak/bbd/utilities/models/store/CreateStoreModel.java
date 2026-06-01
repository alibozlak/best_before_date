package dev.bozlak.bbd.utilities.models.store;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateStoreModel {

    private String storeName;
    private String storeCode;

    public CreateStoreModel(String storeName) {
        this.setStoreName(storeName);
    }
}
