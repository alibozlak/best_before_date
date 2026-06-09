package dev.bozlak.bbd.api;

import dev.bozlak.bbd.dtos.bbdrecord.requests.*;
import dev.bozlak.bbd.dtos.bbdrecord.responses.BbdPastComponentReponseDto;
import dev.bozlak.bbd.dtos.bbdrecord.responses.EditBbdRecordPageResponseDto;
import dev.bozlak.bbd.dtos.forupdatebbdrecordpage.UpdateBbdRecordPageResponseDto;
import dev.bozlak.bbd.service.abstracts.BbdRecordService;
import dev.bozlak.core.responses.ResponseBody;
import dev.bozlak.core.responses.ResponseBodyWithObject;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bbdrecords")
@RequiredArgsConstructor
@Tag(
        name = "BBD Record Management",
        description = "Endpoints for managing Best Before Date list, sales, and record updates."
)
public class BbdRecordController {

    private final BbdRecordService bbdRecordService;

    @PostMapping
    @Operation(summary = "Add BBD Record", description = "Creates a new expiration date record for a product.")
    public ResponseEntity<ResponseBody> add(@RequestBody @Valid AddBbdRecordRequestDto addBbdRecordRequestDto){
        this.bbdRecordService.add(addBbdRecordRequestDto);
        return new ResponseEntity<>(
                new ResponseBody(true),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/get-update-bbd-record-page-model/{bbdRecordId}")
    @Operation(
            summary = "Get Edit Page Model",
            description = "Retrieves the necessary data model to render the BBD record edit page."
    )
    public ResponseEntity<ResponseBodyWithObject<EditBbdRecordPageResponseDto>> getEditBbdRecordPageResponse(
            @PathVariable("bbdRecordId") Long bbdRecordId
    ){
        return new ResponseEntity<>(
                new ResponseBodyWithObject<>(this.bbdRecordService.getEditBbdRecordPageResponse(bbdRecordId)),
                HttpStatus.OK
        );
    }

    @PostMapping("/sale-product")
    @Operation(summary = "Process Product Sale", description = "Updates the inventory quantity of a BBD record after a sale.")
    public ResponseEntity<ResponseBody> saleProduct(@RequestBody SaleProductRequestDto saleProductRequestDto){
        this.bbdRecordService.saleProduct(saleProductRequestDto);
        return new ResponseEntity<>(
                new ResponseBody(true),
                HttpStatus.OK
        );
    }

    @GetMapping("/get-update-bbd-record-page-dto/{bbdRecordId}")
    @Operation(
            summary = "Get Update Page DTO",
            description = "Retrieves a BBD record combined with all available products for updating."
    )
    public ResponseEntity<ResponseBodyWithObject<UpdateBbdRecordPageResponseDto>> getUpdateBbdRecordPageDto(
            @PathVariable("bbdRecordId") Long bbdRecordId
    ){
        return new ResponseEntity<>(
                new ResponseBodyWithObject<>(this.bbdRecordService.getUpdateBbdRecordPageDto(bbdRecordId)),
                HttpStatus.OK
        );
    }

    @PutMapping
    @Operation(summary = "Update BBD Record", description = "Modifies an existing BBD record's details.")
    public ResponseEntity<ResponseBodyWithObject<Long>> updateBbdRecord(
            @RequestBody UpdateBbdRecordRequestDto updateBbdRecordRequestDto
    ){
        return new ResponseEntity<>(
                new ResponseBodyWithObject<>(this.bbdRecordService.updateBbdRecord(updateBbdRecordRequestDto)),
                HttpStatus.OK
        );
    }

    @PutMapping("/soft-delete")
    @Operation(
            summary = "Soft Delete Record",
            description = "Zeroes out the quantity of a BBD record, effectively removing it from active lists."
    )
    public ResponseEntity<ResponseBody> deleteBbdRecordById(
            @RequestBody DeleteBbdRecordRequestDto deleteBbdRecordRequestDto
    ){
        this.bbdRecordService.deleteBbdRecordById(deleteBbdRecordRequestDto);
        return new ResponseEntity<>(
                new ResponseBody(true),
                HttpStatus.OK
        );
    }

    @GetMapping("/get-bbd-past-record-dto/{bbdRecordId}")
    @Operation(
            summary = "Get Past BBD Record Details",
            description = "Retrieves details of a record that has passed its expiration date."
    )
    public ResponseEntity<ResponseBodyWithObject<BbdPastComponentReponseDto>> getBbdPastComponentResponseDto(
            @PathVariable("bbdRecordId") Long bbdRecordId
    ){
        return new ResponseEntity<>(
                new ResponseBodyWithObject<>(this.bbdRecordService.getBbdPastComponentResponseDto(bbdRecordId)),
                HttpStatus.OK
        );
    }

    @PutMapping("/update-for-bbd-past")
    @Operation(
            summary = "Process Past BBD Record",
            description = "Executes operations (like zeroing quantity) for expired products."
    )
    public ResponseEntity<ResponseBody> doOperationBbdPastComponentRequestDto(
            @RequestBody BbdPastComponentRequestDto bbdPastComponentRequestDto
    ){
        this.bbdRecordService.doOperationBbdPastComponentRequestDto(bbdPastComponentRequestDto);
        return new ResponseEntity<>(
                new ResponseBody(true),
                HttpStatus.OK
        );
    }
}
