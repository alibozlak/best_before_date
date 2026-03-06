package dev.bozlak.bbd.dtos.auth;

import dev.bozlak.core.entity.Dto;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponseDto extends Dto {

    private String accessToken;
    private String message;
}
