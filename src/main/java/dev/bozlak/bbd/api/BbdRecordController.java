package dev.bozlak.bbd.api;

import dev.bozlak.bbd.dtos.bbdrecord.requests.AddBbdRecordRequestDto;
import dev.bozlak.bbd.service.abstracts.BbdRecordService;
import dev.bozlak.core.responses.ResponseBody;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bbdrecords")
@RequiredArgsConstructor
public class    BbdRecordController {

    private final BbdRecordService bbdRecordService;

    @PostMapping
    public ResponseBody add(@RequestBody @Valid AddBbdRecordRequestDto addBbdRecordRequestDto){
        this.bbdRecordService.add(addBbdRecordRequestDto);
        return new ResponseBody(true);
    }
}
