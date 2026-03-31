package dev.bozlak.bbd.repository.baseabstracts;

import dev.bozlak.bbd.entities.UserActivity;

public interface UserActivityRepository {

    void save(UserActivity userActivity);
}
