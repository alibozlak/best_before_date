package dev.bozlak.bbd.api;

import dev.bozlak.bbd.dtos.store.CreateStoreRequestDto;
import dev.bozlak.bbd.entities.Store;
import dev.bozlak.bbd.service.abstracts.StoreService;
import dev.bozlak.core.responses.ResponseBodyWithObject;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stores")
@RequiredArgsConstructor
@Tag(name = "Store Management", description = "Endpoints for administering retail store branches.")
public class StoreController {

    private final StoreService storeService;

    @GetMapping("/get-store-by-store-id/{storeId}")
    @Operation(
            summary = "Get store details by ID",
            description = "Fetches details of a specific store."
    )
    public ResponseEntity<ResponseBodyWithObject<Store>> getStoreByStoreId(@PathVariable("storeId") Integer storeId){
        return new ResponseEntity<>(
                new ResponseBodyWithObject<>(this.storeService.getStoreByStoreId(storeId)),
                HttpStatus.OK
        );
    }

    @GetMapping("/get-all")
    @Operation(
            summary = "Get all stores",
            description = "Retrieves a complete list of all registered store branches (For Admin)."
    )
    public ResponseEntity<ResponseBodyWithObject<List<Store>>> getStoreList(){
        return new ResponseEntity<>(
                new ResponseBodyWithObject<>(this.storeService.getStoreList()),
                HttpStatus.OK
        );
    }

    @PostMapping
    @Operation(
            summary = "Create a new store",
            description = "Registers a new store branch into the system and logs the administrative activity."
    )
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
