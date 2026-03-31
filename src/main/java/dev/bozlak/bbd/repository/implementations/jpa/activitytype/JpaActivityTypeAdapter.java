package dev.bozlak.bbd.repository.implementations.jpa.activitytype;

import dev.bozlak.bbd.entities.ActivityType;
import dev.bozlak.bbd.repository.baseabstracts.ActivityTypeRepository;
import dev.bozlak.bbd.repository.implementations.jpa.mappers.ActivityTypeMapperForJpa;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class JpaActivityTypeAdapter implements ActivityTypeRepository {

    private final JpaActivityTypeRepository jpaActivityTypeRepository;
    private final ActivityTypeMapperForJpa activityTypeMapperForJpa;

    @Override
    public List<ActivityType> findAll() {
        List<dev.bozlak.bbd.repository.implementations.jpa.entities.ActivityType> activityTypesForJpa
                = this.jpaActivityTypeRepository.findAll();

        List<ActivityType> activityTypes = new ArrayList<>(activityTypesForJpa.size());

        activityTypesForJpa.forEach(activityType -> activityTypes.add(
                this.activityTypeMapperForJpa.fromJpaActivityTypeEntityToCoreActivityTypeEntity(activityType)
        ));

        return activityTypes;
    }
}
