package dev.bozlak.bbd.api;

import dev.bozlak.bbd.dtos.auth.AuthResponseDto;
import dev.bozlak.bbd.dtos.user.LoginRequestDto;
import dev.bozlak.bbd.service.abstracts.AuthService;
import dev.bozlak.core.responses.ResponseBodyWithObject;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<ResponseBodyWithObject<AuthResponseDto>> login(@Valid @RequestBody LoginRequestDto loginRequestDto){
        return new ResponseEntity<>(
                new ResponseBodyWithObject<>(this.authService.login(loginRequestDto)),
                HttpStatus.OK
        );
    }
}
