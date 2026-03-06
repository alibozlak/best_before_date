package dev.bozlak.bbd.service.abstracts;

import dev.bozlak.bbd.dtos.auth.AuthResponseDto;
import dev.bozlak.bbd.dtos.user.LoginRequestDto;

public interface AuthService {

    AuthResponseDto login(LoginRequestDto loginRequestDto);
}
