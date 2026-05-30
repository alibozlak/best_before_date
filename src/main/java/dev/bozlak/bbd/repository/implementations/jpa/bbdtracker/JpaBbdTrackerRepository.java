package dev.bozlak.bbd.repository.implementations.jpa.bbdtracker;

import dev.bozlak.bbd.repository.implementations.jpa.entities.BbdTracker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaBbdTrackerRepository extends JpaRepository<BbdTracker, Integer> {

    @Query("SELECT bbdTracker.id FROM BbdTracker bbdTracker WHERE bbdTracker.user.id = :userId")
    Integer getBbdTrackerIdByUserId(@Param("userId") Integer userId);
}
