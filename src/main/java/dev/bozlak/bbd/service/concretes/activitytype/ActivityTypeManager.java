package dev.bozlak.bbd.service.concretes.activitytype;

import dev.bozlak.bbd.entities.ActivityType;
import dev.bozlak.bbd.repository.baseabstracts.ActivityTypeRepository;
import dev.bozlak.bbd.service.abstracts.ActivityTypeService;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ActivityTypeManager implements ActivityTypeService {

    private final ActivityTypeRepository activityTypeRepository;

    @Override
    public List<ActivityType> getAllActivityType() {
        return activityTypeRepository.findAll();
    }
}
