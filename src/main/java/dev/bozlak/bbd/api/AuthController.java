package dev.bozlak.bbd.api;

import dev.bozlak.bbd.dtos.auth.AuthResponseDto;
import dev.bozlak.bbd.dtos.user.LoginRequestDto;
import dev.bozlak.bbd.service.abstracts.AuthService;
import dev.bozlak.core.responses.ResponseBodyWithObject;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Authentication Management", description = "Endpoints for user login and token generation.")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    @Operation(
            summary = "User Login",
            description = "Authenticates a user with username (actually userCode) and password, " +
                    "returning a JWT and user authorities.\n" +
                    "Initial First Fake users : \n" +
                    "For Admin : {userName : '1000', password : 'admin'}\n" +
                    "For BbdTracker : {userName : '1001', password : 'bbdTracker'}\n" +
                    "For Other user : {userName : '1002', password : 'user'}"
    )
    public ResponseEntity<ResponseBodyWithObject<AuthResponseDto>> login(@Valid @RequestBody LoginRequestDto loginRequestDto){
        return new ResponseEntity<>(
                new ResponseBodyWithObject<>(this.authService.login(loginRequestDto)),
                HttpStatus.OK
        );
    }
}
