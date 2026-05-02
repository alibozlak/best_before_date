package dev.bozlak.bbd.service.concretes.userhimselfactivity;

import dev.bozlak.bbd.repository.baseabstracts.UserHimselfActivityRepository;
import dev.bozlak.bbd.service.abstracts.UserHimselfActivityService;
import dev.bozlak.bbd.utilities.models.userhimselactivity.AddUserHimselfActivityModel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserHimselfActivityManager implements UserHimselfActivityService {

    private final UserHimselfActivityRepository userHimselfActivityRepository;

    @Override
    public void add(AddUserHimselfActivityModel addUserHimselfActivityModel) {
        this.userHimselfActivityRepository.add(addUserHimselfActivityModel);
    }
}
