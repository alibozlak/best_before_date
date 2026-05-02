package dev.bozlak.bbd.dtos.homepage;

import dev.bozlak.core.entity.Dto;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class HomePageResponseDto extends Dto {

    private Integer userId;
    private Boolean hasStore;
    private Boolean isAdmin;

}
