package dev.bozlak.bbd.dtos.auth;

import dev.bozlak.bbd.entities.ActivityType;
import dev.bozlak.core.entity.Dto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponseDto extends Dto {

    private String accessToken;
    private Boolean isUserAdmin;
    private Integer userId;
    private List<ActivityType> activityTypes;
}
