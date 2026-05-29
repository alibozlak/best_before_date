package dev.bozlak.bbd.repository.implementations.jpa.bbdtracker;

import dev.bozlak.bbd.repository.baseabstracts.BbdTrackerRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class JpaBbdTrackerRepositoryAdapter implements BbdTrackerRepository {

    private final JpaBbdTrackerRepository jpaBbdTrackerRepository;

    @Override
    public Integer getBbdTrackerIdByUserId(Integer userId) {
        return this.jpaBbdTrackerRepository.getBbdTrackerIdByUserId(userId);
    }
}
