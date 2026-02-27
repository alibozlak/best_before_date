package dev.bozlak.bbd.dtos.user;

import dev.bozlak.core.entity.Dto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddUserRequestDto extends Dto {

    private String userName;

    private String password;

    private Integer storeId;
}
