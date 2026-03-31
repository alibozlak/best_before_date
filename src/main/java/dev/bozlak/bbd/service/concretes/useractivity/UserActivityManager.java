package dev.bozlak.bbd.service.concretes.useractivity;

import dev.bozlak.bbd.entities.UserActivity;
import dev.bozlak.bbd.repository.baseabstracts.UserActivityRepository;
import dev.bozlak.bbd.service.abstracts.UserActivityService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserActivityManager implements UserActivityService  {

    private final UserActivityRepository userActivityRepository;

    @Override
    public void add(UserActivity userActivity) {
        this.userActivityRepository.save(userActivity);
    }
}
