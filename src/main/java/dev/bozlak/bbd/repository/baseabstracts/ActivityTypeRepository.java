package dev.bozlak.bbd.repository.baseabstracts;

import dev.bozlak.bbd.entities.ActivityType;

import java.util.List;

public interface ActivityTypeRepository {

    List<ActivityType> findAll();
}
