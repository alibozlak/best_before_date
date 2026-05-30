package dev.bozlak.bbd.repository.implementations.jpa.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "products_logs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "bbd_tracker_id")
    @ManyToOne
    private BbdTracker bbdTracker;

    @JoinColumn(name = "user_id", nullable = false)
    @ManyToOne
    private User user;

    @JoinColumn(name = "activity_type_id", nullable = false)
    @ManyToOne
    private ActivityType activityType;

    public ProductLog(BbdTracker bbdTracker, User user, ActivityType activityType) {
        this.bbdTracker = bbdTracker;
        this.user = user;
        this.activityType = activityType;
    }
}
