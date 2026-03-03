package dev.bozlak.bbd.service.concretes.bbdrecord;

import dev.bozlak.bbd.dtos.bbdrecord.AddBbdRecordRequestDto;
import dev.bozlak.bbd.entities.BbdRecord;
import dev.bozlak.bbd.repository.BbdRecordRepository;
import dev.bozlak.bbd.service.abstracts.BbdRecordService;
import dev.bozlak.bbd.service.abstracts.ProductService;
import dev.bozlak.bbd.service.abstracts.UserService;
import dev.bozlak.bbd.utilities.mappers.BbdRecordMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FirstBbdRecordService implements BbdRecordService {

    private final BbdRecordRepository bbdRecordRepository;
    private final BbdRecordMapper bbdRecordMapper;
    private final UserService userService;
    private final ProductService productService;

    @Override
    public void add(AddBbdRecordRequestDto addBbdRecordRequestDto) {
        if (!doesExistProductIdGivenNumber(addBbdRecordRequestDto.getProductId()))
            throw new RuntimeException("Doesn't exist record in products table given number for product id!!");
        if (!doesExistUserIdGivenNumber(addBbdRecordRequestDto.getUserId()))
            throw new RuntimeException("Doesn't exist record in users table given number for user id!!");

        BbdRecord bbdRecord =
                this.bbdRecordMapper.fromAddBbdRecordRequestDtoToBbdRecordEntity(addBbdRecordRequestDto);
        this.bbdRecordRepository.save(bbdRecord);
    }

    private boolean doesExistProductIdGivenNumber(Integer productId){
        return this.productService.doesExistProductIdGivenNumber(productId);
    }

    private boolean doesExistUserIdGivenNumber(Integer userId){
        return this.userService.doesExistUserIdGivenNumber(userId);
    }
}
