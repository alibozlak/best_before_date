package dev.bozlak.bbd.service.concretes.bbdrecord;

import dev.bozlak.bbd.dtos.bbdrecord.requests.AddBbdRecordRequestDto;
import dev.bozlak.bbd.entities.BbdRecord;
import dev.bozlak.bbd.entities.UserActivity;
import dev.bozlak.bbd.repository.baseabstracts.BbdRecordRepository;
import dev.bozlak.bbd.service.abstracts.BbdRecordService;
import dev.bozlak.bbd.service.abstracts.ProductService;
import dev.bozlak.bbd.service.abstracts.UserActivityService;
import dev.bozlak.bbd.service.abstracts.UserService;
import dev.bozlak.bbd.utilities.mappers.BbdRecordMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RequiredArgsConstructor
public class BbdRecordManager implements BbdRecordService {

    private final BbdRecordRepository bbdRecordRepository;
    private final BbdRecordMapper bbdRecordMapper;
    private final UserService userService;
    private final ProductService productService;
    private final UserActivityService userActivityService;

    @Override
    @Transactional
    public void add(AddBbdRecordRequestDto addBbdRecordRequestDto) {
        Integer productId = addBbdRecordRequestDto.getProductId();
        if (!doesExistProductIdGivenNumber(productId))
            throw new RuntimeException("Doesn't exist record in products table given number for product id!!");
        Integer userId = addBbdRecordRequestDto.getUserId();
        if (!doesExistUserIdGivenNumber(userId))
            throw new RuntimeException("Doesn't exist record in users table given number for user id!!");

        BbdRecord bbdRecord =
                this.bbdRecordMapper.fromAddBbdRecordRequestDtoToBbdRecordEntity(addBbdRecordRequestDto);

        Integer storeId = this.userService.getStoreIdByUserId(userId);
        bbdRecord.setStoreId(storeId);

        Short howManyDaysAgoForRemoval = this.productService.getHowManyDaysAgoForRemovalByProductId(productId);
        LocalDate removalDate = addBbdRecordRequestDto.getBestBeforeDate().minusDays((long)howManyDaysAgoForRemoval);
        bbdRecord.setRemovalDate(removalDate);

        this.bbdRecordRepository.save(bbdRecord);

        UserActivity userActivity = new UserActivity();
        userActivity.setUserId(addBbdRecordRequestDto.getUserId());
        userActivity.setStoreId(storeId);
        userActivity.setAddedDateTime(LocalDateTime.now());
        userActivity.setProductId(addBbdRecordRequestDto.getProductId());
        userActivity.setQuantity(addBbdRecordRequestDto.getQuantity());
        userActivity.setActivityTypeId(addBbdRecordRequestDto.getActivityTypeId());
        this.userActivityService.add(userActivity);
    }

    private boolean doesExistProductIdGivenNumber(Integer productId){
        return this.productService.doesExistProductIdGivenNumber(productId);
    }

    private boolean doesExistUserIdGivenNumber(Integer userId){
        return this.userService.doesExistUserIdGivenNumber(userId);
    }
}
