package dev.bozlak.bbd.api;

import dev.bozlak.bbd.dtos.bbdrecord.requests.AddBbdRecordRequestDto;
import dev.bozlak.bbd.dtos.bbdrecord.requests.SaleProductRequestDto;
import dev.bozlak.bbd.service.abstracts.BbdRecordService;
import dev.bozlak.core.responses.ResponseBody;
import dev.bozlak.core.responses.ResponseBodyWithObject;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bbdrecords")
@RequiredArgsConstructor
public class BbdRecordController {

    private final BbdRecordService bbdRecordService;

    @PostMapping
    public ResponseBody add(@RequestBody @Valid AddBbdRecordRequestDto addBbdRecordRequestDto){
        this.bbdRecordService.add(addBbdRecordRequestDto);
        return new ResponseBody(true);
    }

    @PostMapping("/sale-product")
    public ResponseBody saleProduct(@RequestBody SaleProductRequestDto saleProductRequestDto){
        System.out.println(saleProductRequestDto);
        this.bbdRecordService.saleProduct(saleProductRequestDto);
        return new ResponseBody(true);
    }
}
