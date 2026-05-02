package dev.bozlak.bbd.repository.implementations.jpa.userhimselfactivity;

import dev.bozlak.bbd.repository.baseabstracts.UserHimselfActivityRepository;
import dev.bozlak.bbd.repository.implementations.jpa.entities.UserHimselfActivity;
import dev.bozlak.bbd.repository.implementations.jpa.mappers.UserHimselfActivityMapperForJpa;
import dev.bozlak.bbd.utilities.models.userhimselactivity.AddUserHimselfActivityModel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class JpaUserHimselfActivityAdapter implements UserHimselfActivityRepository {

    private final JpaUserHimselfActivityRepository jpaUserHimselfActivityRepository;
    private final UserHimselfActivityMapperForJpa userHimselfActivityMapperForJpa;

    @Override
    public void add(AddUserHimselfActivityModel addUserHimselfActivityModel) {
        UserHimselfActivity userHimselfActivity =
                this.userHimselfActivityMapperForJpa.toUserHimselfActivityFromItsAddModel(addUserHimselfActivityModel);

        this.jpaUserHimselfActivityRepository.save(userHimselfActivity);
    }
}
