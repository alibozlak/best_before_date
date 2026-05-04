package dev.bozlak.bbd.dtos.user;

import dev.bozlak.core.entity.Dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestDtoForListCoworkers extends Dto {

    private Integer userId;
    private Integer storeId;
}
