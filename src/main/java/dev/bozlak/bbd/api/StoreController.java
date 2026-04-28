package dev.bozlak.bbd.api;

import dev.bozlak.bbd.entities.Store;
import dev.bozlak.bbd.service.abstracts.StoreService;
import dev.bozlak.core.responses.ResponseBodyWithObject;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stores")
@RequiredArgsConstructor
public class StoreController {

    private final StoreService storeService;

    @PostMapping("/get-store-by-store-id")
    public ResponseBodyWithObject<Store> getStoreByStoreId(@RequestBody Integer storeId){
        return new ResponseBodyWithObject<>(this.storeService.getStoreByStoreId(storeId));
    }

    @GetMapping("/get-all")
    public ResponseBodyWithObject<List<Store>> getStoreList(){
        return new ResponseBodyWithObject<>(this.storeService.getStoreList());
    }
}
