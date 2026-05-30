package dev.bozlak.bbd.repository.implementations.jpa.productlog;

import dev.bozlak.bbd.entities.ActivityType;
import dev.bozlak.bbd.repository.baseabstracts.ActivityTypeRepository;
import dev.bozlak.bbd.repository.baseabstracts.ProductLogRepository;
import dev.bozlak.bbd.repository.baseabstracts.UserRepository;
import dev.bozlak.bbd.repository.implementations.jpa.entities.BbdTracker;
import dev.bozlak.bbd.repository.implementations.jpa.entities.ProductLog;
import dev.bozlak.bbd.repository.implementations.jpa.entities.User;
import dev.bozlak.bbd.repository.implementations.jpa.mappers.ActivityTypeMapperForJpa;
import dev.bozlak.bbd.repository.implementations.jpa.mappers.ProductLogMapperForJpa;
import dev.bozlak.bbd.repository.implementations.jpa.mappers.UserMapperForJpa;
import dev.bozlak.bbd.utilities.models.productlog.AddProductLogModel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class JpaProductLogRepositoryAdapter implements ProductLogRepository {

    private final JpaProductLogRepository jpaProductLogRepository;
    private final ProductLogMapperForJpa productLogMapperForJpa;
    private final UserRepository userRepository;
    private final UserMapperForJpa userMapperForJpa;
    private final ActivityTypeRepository activityTypeRepository;
    private final ActivityTypeMapperForJpa activityTypeMapperForJpa;

    @Override
    public void add(AddProductLogModel addProductLogModel) {
        dev.bozlak.bbd.entities.User userForCoreEntity = this.userRepository.getUserByUserId(
                addProductLogModel.getUserId()
        );
        User userForJpa = this.userMapperForJpa.fromCoreUserToJpaUser(userForCoreEntity);

        ActivityType activityTypeForCoreEntity = this.activityTypeRepository.getActivityTypeByActivityTypeId(
                addProductLogModel.getActivityTypeId()
        );
        dev.bozlak.bbd.repository.implementations.jpa.entities.ActivityType activityTypeForJpa
                = this.activityTypeMapperForJpa.fromCoreActivityTypeToJpaActiviyType(activityTypeForCoreEntity);

        ProductLog productLog = new ProductLog(
                new BbdTracker(
                        addProductLogModel.getBbdTrackerId(),
                        userForJpa,
                        null
                ),
                userForJpa,
                activityTypeForJpa
        );

        this.jpaProductLogRepository.save(productLog);
    }
}
