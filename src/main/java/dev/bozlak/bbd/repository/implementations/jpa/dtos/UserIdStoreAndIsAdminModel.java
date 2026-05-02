package dev.bozlak.bbd.repository.implementations.jpa.dtos;

import dev.bozlak.bbd.repository.implementations.jpa.entities.Store;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserIdStoreAndIsAdminModel {

    private Integer userId;
    private Store store;
    private Boolean isAdmin;
}
