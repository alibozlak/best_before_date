package dev.bozlak.bbd.repository.implementations.jpa.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "bbd_list")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BbdRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer storeId;

    @JoinColumn(name = "product_id", nullable = false)
    @ManyToOne
    private Product product;

    @Column(nullable = false)
    private LocalDate bestBeforeDate;

    @Column(nullable = false)
    private LocalDate removalDate;

    @Column(nullable = false)
    private Short quantity;
}
