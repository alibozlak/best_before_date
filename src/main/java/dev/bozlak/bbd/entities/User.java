package dev.bozlak.bbd.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User extends dev.bozlak.core.entity.Entity {

    private Integer id;
    private String userName;
    private String password;
    private Integer storeId;
    private Boolean isAdmin;
    private Boolean isActive;

    //--------------Constructors-------------

    public User(Integer userId) {
        this.setId(userId);
    }
}
