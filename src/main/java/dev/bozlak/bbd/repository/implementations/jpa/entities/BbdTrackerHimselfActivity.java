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
@Table(name = "bbd_tracker_himself_activities")
public class BbdTrackerHimselfActivity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "bbd_tracker_id", nullable = false)
    @OneToOne
    private BbdTracker bbdTracker;

    @JoinColumn(name = "activity_type_id", nullable = false)
    @ManyToOne
    private ActivityType activityType;

    @JoinColumn(name = "added_or_deleted_user_id", nullable = false)
    @ManyToOne
    private User addedOrDeletedUser;
}
