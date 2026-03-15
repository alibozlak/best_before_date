package dev.bozlak.bbd.service.concretes.activitytype;

import dev.bozlak.bbd.entities.ActivityType;
import dev.bozlak.bbd.repository.ActivityTypeRepository;
import dev.bozlak.bbd.service.abstracts.ActivityTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FirstActivityTypeService implements ActivityTypeService {

    private final ActivityTypeRepository activityTypeRepository;

    @Override
    public List<ActivityType> getAllActivityType() {
        return activityTypeRepository.findAll();
    }
}
