package dev.bozlak.bbd.service.concretes.useractivity;

import dev.bozlak.bbd.entities.UserActivity;
import dev.bozlak.bbd.repository.UserActivityRepository;
import dev.bozlak.bbd.service.abstracts.UserActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FirstUserActivityService implements UserActivityService  {

    private final UserActivityRepository userActivityRepository;

    @Override
    public void add(UserActivity userActivity) {
        this.userActivityRepository.save(userActivity);
    }
}
