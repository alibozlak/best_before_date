package dev.bozlak.bbd.api;

import dev.bozlak.bbd.dtos.product.requests.AddProductRequestDto;
import dev.bozlak.bbd.dtos.product.responses.ProductIdNameCodeAndPriceResponseDto;
import dev.bozlak.bbd.service.abstracts.ProductService;
import dev.bozlak.core.responses.ResponseBody;
import dev.bozlak.core.responses.ResponseBodyWithObject;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ResponseBody> addProduct(@Valid @RequestBody AddProductRequestDto addProductRequestDto){
        //FixMe :
        Byte addProductActivityTypeId = 12;
        addProductRequestDto.setActivityTypeId(addProductActivityTypeId);

        this.productService.add(addProductRequestDto);
        return new ResponseEntity<>(
                new ResponseBody(true),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/get-all-product-id-name-code-and-price-dto")
    public ResponseEntity<ResponseBodyWithObject<List<ProductIdNameCodeAndPriceResponseDto>>> getAllProductIdNameCodePriceDto(){
        return new ResponseEntity<>(
                new ResponseBodyWithObject<>(this.productService.getAllProductIdNameCodeAndPriceDto()),
                HttpStatus.OK
        );
    }
}
