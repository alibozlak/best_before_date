package dev.bozlak.bbd.repository.implementations.jpa.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_activities")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserActivity extends dev.bozlak.core.entity.Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "bbd_record_id", nullable = false)
    private BbdRecord bbdRecord;

    @Column(nullable = false)
    private LocalDateTime addedDateTime;

    /**
     * Count of Activity Type
     */
    @Column(nullable = false)
    private Short quantity;

    @ManyToOne
    @JoinColumn(name = "activity_type_id", nullable = false)
    private ActivityType activityType;

    @Column(nullable = true)
    private String activityNote;
}