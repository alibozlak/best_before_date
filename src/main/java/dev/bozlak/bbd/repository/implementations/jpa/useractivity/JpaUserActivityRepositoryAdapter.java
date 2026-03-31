package dev.bozlak.bbd.repository.implementations.jpa.useractivity;

import dev.bozlak.bbd.entities.UserActivity;
import dev.bozlak.bbd.repository.baseabstracts.UserActivityRepository;
import dev.bozlak.bbd.repository.implementations.jpa.mappers.UserActivityMapperForJpa;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class JpaUserActivityRepositoryAdapter implements UserActivityRepository {

    private final JpaUserActivityRepository jpaUserActivityRepository;
    private final UserActivityMapperForJpa userActivityMapperForJpa;

    @Override
    public void save(UserActivity userActivity) {
        dev.bozlak.bbd.repository.implementations.jpa.entities.UserActivity userActivityForJpa
                = this.userActivityMapperForJpa.fromUserActivityCoreEntityToUserActivityForJpa(userActivity);

        this.jpaUserActivityRepository.save(userActivityForJpa);
    }
}
