package dev.bozlak.bbd.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "bbd_list")
@Getter
@Setter
public class BbdList extends dev.bozlak.core.entity.Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@Column(nullable = false)
    @JoinColumn(name = "user_id", nullable = false)
    @ManyToOne
    private User user;

    //@Column(nullable = false)
    @JoinColumn(name = "product_id", nullable = false)
    @ManyToOne
    private Product product;

    @Column(nullable = false)
    private LocalDate bestBeforeDate;

    @Column(nullable = false)
    private Short quantity;
}
