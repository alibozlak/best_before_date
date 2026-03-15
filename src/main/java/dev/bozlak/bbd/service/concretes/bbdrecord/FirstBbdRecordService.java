package dev.bozlak.bbd.service.concretes.bbdrecord;

import dev.bozlak.bbd.dtos.bbdrecord.AddBbdRecordRequestDto;
import dev.bozlak.bbd.entities.*;
import dev.bozlak.bbd.repository.BbdRecordRepository;
import dev.bozlak.bbd.service.abstracts.BbdRecordService;
import dev.bozlak.bbd.service.abstracts.ProductService;
import dev.bozlak.bbd.service.abstracts.UserActivityService;
import dev.bozlak.bbd.service.abstracts.UserService;
import dev.bozlak.bbd.utilities.mappers.BbdRecordMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class FirstBbdRecordService implements BbdRecordService {

    private final BbdRecordRepository bbdRecordRepository;
    private final BbdRecordMapper bbdRecordMapper;
    private final UserService userService;
    private final ProductService productService;
    private final UserActivityService userActivityService;

    @Override
    public void add(AddBbdRecordRequestDto addBbdRecordRequestDto) {
        if (!doesExistProductIdGivenNumber(addBbdRecordRequestDto.getProductId()))
            throw new RuntimeException("Doesn't exist record in products table given number for product id!!");
        if (!doesExistUserIdGivenNumber(addBbdRecordRequestDto.getUserId()))
            throw new RuntimeException("Doesn't exist record in users table given number for user id!!");

        BbdRecord bbdRecord =
                this.bbdRecordMapper.fromAddBbdRecordRequestDtoToBbdRecordEntity(addBbdRecordRequestDto);
        //System.out.println("bbdRecord.getUser().getUserName() = " + bbdRecord.getUser().getUserName());
        //bbdRecord.getUser().getUserName() = null
        //System.out.println(bbdRecord.getProduct().getProductName());
        //null
        this.bbdRecordRepository.save(bbdRecord);

        UserActivity userActivity = new UserActivity();
        userActivity.setUser(new User(addBbdRecordRequestDto.getUserId()));
        userActivity.setStoreId(this.userService.getStoreIdByUserId(addBbdRecordRequestDto.getUserId()));
        userActivity.setAddedDateTime(LocalDateTime.now());
        userActivity.setProduct(new Product(addBbdRecordRequestDto.getProductId()));
        userActivity.setQuantity(addBbdRecordRequestDto.getQuantity());
        userActivity.setActivityType(new ActivityType(addBbdRecordRequestDto.getActivityTypeId()));
        this.userActivityService.add(userActivity);
    }

    private boolean doesExistProductIdGivenNumber(Integer productId){
        return this.productService.doesExistProductIdGivenNumber(productId);
    }

    private boolean doesExistUserIdGivenNumber(Integer userId){
        return this.userService.doesExistUserIdGivenNumber(userId);
    }
}
