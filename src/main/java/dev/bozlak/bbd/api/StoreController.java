package dev.bozlak.bbd.api;

import dev.bozlak.bbd.entities.Store;
import dev.bozlak.bbd.service.abstracts.StoreService;
import dev.bozlak.core.responses.ResponseBodyWithObject;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/stores")
@RequiredArgsConstructor
public class StoreController {

    private final StoreService storeService;

    @PostMapping("/get-store-by-store-id")
    public ResponseBodyWithObject<Store> getStoreByStoreId(@RequestBody Integer storeId){
        return new ResponseBodyWithObject<>(this.storeService.getStoreByStoreId(storeId));
    }
}
