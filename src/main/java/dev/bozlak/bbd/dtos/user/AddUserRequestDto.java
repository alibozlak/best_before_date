package dev.bozlak.bbd.dtos.user;

import dev.bozlak.core.entity.Dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AddUserRequestDto extends Dto {

    @NotNull(message = "Username must be not null!!")
    @NotBlank(message = "Username must be not blank!!")
    private String userName;

    @NotNull(message = "Password must be not null!!")
    @NotBlank(message = "Password must be not blank!!")
    private String password;

    private Integer storeId;

    private Boolean isAdmin;

    private Boolean isActive;

    private Boolean isBbdTracker;
}
