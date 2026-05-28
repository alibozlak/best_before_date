package dev.bozlak.bbd.repository.baseabstracts;

import dev.bozlak.bbd.utilities.models.productlog.AddProductLogModel;

public interface ProductLogRepository {

    void add(AddProductLogModel addProductLogModel);
}
