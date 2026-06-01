package dev.bozlak.bbd.repository.implementations.jpa.adminstoreactivity;

import dev.bozlak.bbd.repository.implementations.jpa.entities.AdminStoreActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaAdminStoreActivityRepository extends JpaRepository<AdminStoreActivity, Integer> {
}
