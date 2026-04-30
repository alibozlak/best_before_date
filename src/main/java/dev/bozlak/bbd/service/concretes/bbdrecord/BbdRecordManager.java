package dev.bozlak.bbd.service.concretes.bbdrecord;

import dev.bozlak.bbd.dtos.bbdrecord.modelsforbackend.BbdRecordIdAndQuantityModel;
import dev.bozlak.bbd.dtos.bbdrecord.requests.*;
import dev.bozlak.bbd.dtos.bbdrecord.responses.BbdPastComponentReponseDto;
import dev.bozlak.bbd.dtos.bbdrecord.responses.BbdRecordWithoutRemovalDateResponse;
import dev.bozlak.bbd.dtos.bbdrecord.responses.EditBbdRecordPageResponseDto;
import dev.bozlak.bbd.dtos.forupdatebbdrecordpage.UpdateBbdRecordPageResponseDto;
import dev.bozlak.bbd.dtos.product.responses.ProductIdNameCodeAndPriceResponseDto;
import dev.bozlak.bbd.entities.BbdRecord;
import dev.bozlak.bbd.entities.UserActivity;
import dev.bozlak.bbd.repository.baseabstracts.BbdRecordRepository;
import dev.bozlak.bbd.service.abstracts.BbdRecordService;
import dev.bozlak.bbd.service.abstracts.ProductService;
import dev.bozlak.bbd.service.abstracts.UserActivityService;
import dev.bozlak.bbd.service.abstracts.UserService;
import dev.bozlak.bbd.utilities.mappers.BbdRecordMapper;
import dev.bozlak.bbd.utilities.mappers.UserActivityMapper;
import dev.bozlak.bbd.utilities.models.useractivity.AddUserActivityModel;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
public class BbdRecordManager implements BbdRecordService {

    private final BbdRecordRepository bbdRecordRepository;
    private final BbdRecordMapper bbdRecordMapper;
    private final UserActivityMapper userActivityMapper;
    private final UserService userService;
    private final ProductService productService;
    private final UserActivityService userActivityService;

    @Override
    @Transactional
    public void add(AddBbdRecordRequestDto addBbdRecordRequestDto) {

        BbdRecord bbdRecord = this.utilMethodForAddAndUpdateBbdRecord(addBbdRecordRequestDto);
        Long returnedBbdRecordId = this.bbdRecordRepository.save(bbdRecord);

        AddUserActivityModel addUserActivityModel = this.userActivityMapper
                .toAddUserActivityModelFromAddBbdRecordRequestDto(addBbdRecordRequestDto);
        addUserActivityModel.setBbdRecordId(returnedBbdRecordId);
        this.addUserActivity(addUserActivityModel);
    }

    @Override
    public EditBbdRecordPageResponseDto getEditBbdRecordPageResponse(Long bbdRecordId) {
        var editBbdRecordPageResponseDtoWithoutProductName
                = this.bbdRecordRepository.getBbdRecordWithoutRemovalDateResponseDtoByBbdRecordId(bbdRecordId);

        String productName = this.productService.getProductNameByProductId(
                editBbdRecordPageResponseDtoWithoutProductName.getProductId()
        );

        return new EditBbdRecordPageResponseDto(editBbdRecordPageResponseDtoWithoutProductName, productName);
    }

    @Override
    @Transactional
    public void saleProduct(SaleProductRequestDto saleProductRequestDto) {
        this.bbdRecordRepository.saleProduct(new BbdRecordIdAndQuantityModel(
                        saleProductRequestDto.getBbdRecordId(), saleProductRequestDto.getNewQuantity()
                )
        );

        this.addUserActivity(saleProductRequestDto);
    }

    @Override
    public UpdateBbdRecordPageResponseDto getUpdateBbdRecordPageDto(Long bbdRecordId) {
        BbdRecordWithoutRemovalDateResponse bbdRecordWithoutRemovalDateResponse
                = this.bbdRecordRepository.getBbdRecordWithoutRemovalDateResponseDtoByBbdRecordId(bbdRecordId);

        List<ProductIdNameCodeAndPriceResponseDto> productIdNameCodeAndPriceResponseDtoList
                = this.productService.getAllProductIdNameCodeAndPriceDto();

        return new UpdateBbdRecordPageResponseDto(
                bbdRecordWithoutRemovalDateResponse, productIdNameCodeAndPriceResponseDtoList
        );
    }

    @Override
    @Transactional
    public Long updateBbdRecord(UpdateBbdRecordRequestDto updateBbdRecordRequestDto) {

        BbdRecord bbdRecord = this.utilMethodForAddAndUpdateBbdRecord(updateBbdRecordRequestDto);
        bbdRecord.setId(updateBbdRecordRequestDto.getBbdRecordId());
        Long returnedBbdRecordId = this.bbdRecordRepository.updateBbdRecord(bbdRecord);

        AddUserActivityModel addUserActivityModel = this.userActivityMapper
                .toAddUserActivityModelFromUpdateBbdRecordRequestDto(updateBbdRecordRequestDto);
        this.addUserActivity(addUserActivityModel);

        return returnedBbdRecordId;
    }

    @Override
    @Transactional
    public Boolean deleteBbdRecordById(DeleteBbdRecordRequestDto deleteBbdRecordRequestDto) {

        if (this.bbdRecordRepository.deleteBbdRecordById(deleteBbdRecordRequestDto.getBbdRecordId())){
            this.addUserActivity(deleteBbdRecordRequestDto);
            return true;
        }

        return false;
    }

    @Override
    public BbdPastComponentReponseDto getBbdPastComponentResponseDto(Long bbdRecordId) {
        return this.bbdRecordRepository.getBbdPastComponentResponseDto(bbdRecordId);
    }

    @Override
    @Transactional
    public void doOperationBbdPastComponentRequestDto(BbdPastComponentRequestDto bbdPastComponentRequestDto) {
        this.bbdRecordRepository.setQuantityColumnZeroInBbdListTable(bbdPastComponentRequestDto.getBbdRecordId());

        this.addUserActivity(bbdPastComponentRequestDto);
    }

    private BbdRecord utilMethodForAddAndUpdateBbdRecord(AddBbdRecordRequestDto addBbdRecordRequestDto){
        Integer productId = addBbdRecordRequestDto.getProductId();
        Integer userId = addBbdRecordRequestDto.getUserId();

        BbdRecord bbdRecord =
                this.bbdRecordMapper.fromAddBbdRecordRequestDtoToBbdRecordEntity(addBbdRecordRequestDto);

        Integer storeId = this.userService.getStoreIdByUserId(userId);
        bbdRecord.setStoreId(storeId);

        Short howManyDaysAgoForRemoval = this.productService.getHowManyDaysAgoForRemovalByProductId(productId);
        LocalDate removalDate = addBbdRecordRequestDto.getBestBeforeDate().minusDays((long)howManyDaysAgoForRemoval);
        bbdRecord.setRemovalDate(removalDate);

        return bbdRecord;
    }

    private void addUserActivity(AddUserActivityModel addUserActivityModel){
        UserActivity userActivity = this.userActivityMapper
                .toUserActivityFromAddUserActivityModel(addUserActivityModel);

        userActivity.setAddedDateTime(LocalDateTime.now());
        this.userActivityService.add(userActivity);
    }
}
