package dev.bozlak.bbd.repository.implementations.jpa.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "admin_store_activities")
public class AdminStoreActivity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JoinColumn(name = "admin_id", nullable = false)
    @ManyToOne
    private Admin admin;

    @JoinColumn(name = "store_id", nullable = false)
    @ManyToOne
    private Store store;

    @JoinColumn(name = "activity_type_id", nullable = false)
    @ManyToOne
    private ActivityType activityType;
}
