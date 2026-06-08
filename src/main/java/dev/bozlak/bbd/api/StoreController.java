package dev.bozlak.bbd.api;

import dev.bozlak.bbd.dtos.store.CreateStoreRequestDto;
import dev.bozlak.bbd.entities.Store;
import dev.bozlak.bbd.service.abstracts.StoreService;
import dev.bozlak.core.responses.ResponseBodyWithObject;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stores")
@RequiredArgsConstructor
public class StoreController {

    private final StoreService storeService;

    @PostMapping("/get-store-by-store-id")
    public ResponseEntity<ResponseBodyWithObject<Store>> getStoreByStoreId(@RequestBody Integer storeId){
        return new ResponseEntity<>(
                new ResponseBodyWithObject<>(this.storeService.getStoreByStoreId(storeId)),
                HttpStatus.OK
        );
    }

    @GetMapping("/get-all")
    public ResponseEntity<ResponseBodyWithObject<List<Store>>> getStoreList(){
        return new ResponseEntity<>(
                new ResponseBodyWithObject<>(this.storeService.getStoreList()),
                HttpStatus.OK
        );
    }

    @PostMapping
    public ResponseEntity<dev.bozlak.core.responses.ResponseBody> createStore(
            @RequestBody CreateStoreRequestDto createStoreRequestDto
    ){
        this.storeService.createStore(createStoreRequestDto);
        return new ResponseEntity<>(
                new dev.bozlak.core.responses.ResponseBody(true),
                HttpStatus.CREATED
        );
    }
}
