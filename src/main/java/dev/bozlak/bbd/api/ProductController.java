package dev.bozlak.bbd.api;

import dev.bozlak.bbd.dtos.product.AddProductRequestDto;
import dev.bozlak.bbd.service.abstracts.ProductService;
import dev.bozlak.core.responses.ResponseBody;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseBody addProduct(@Valid @RequestBody AddProductRequestDto addProductRequestDto){
        this.productService.add(addProductRequestDto);
        return new ResponseBody(true);
    }
}
