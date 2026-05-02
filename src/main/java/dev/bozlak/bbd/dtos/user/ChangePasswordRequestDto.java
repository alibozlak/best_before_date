package dev.bozlak.bbd.dtos.user;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ChangePasswordRequestDto {

    private Integer userId;
    private String previousPassword;
    private String newPassword;

    private Byte activityTypeId;
}
