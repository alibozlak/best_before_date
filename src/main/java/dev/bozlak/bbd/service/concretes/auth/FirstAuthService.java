package dev.bozlak.bbd.service.concretes.auth;

import dev.bozlak.bbd.dtos.auth.AuthResponseDto;
import dev.bozlak.bbd.dtos.user.LoginRequestDto;
import dev.bozlak.bbd.service.abstracts.AuthService;
import dev.bozlak.bbd.utilities.security.CustomUserDetailsService;
import dev.bozlak.bbd.utilities.security.FirstJwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FirstAuthService implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final CustomUserDetailsService customUserDetailsService;
    private final FirstJwtService firstJwtService;

    @Override
    public AuthResponseDto login(LoginRequestDto loginRequestDto){
        final String userName = loginRequestDto.getUserName();
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userName, loginRequestDto.getPassword())
        );

        UserDetails userDetails = this.customUserDetailsService.loadUserByUsername(userName);

        String jwtToken = this.firstJwtService.generateToken(userDetails);

        return AuthResponseDto.builder()
                .accessToken(jwtToken)
                .isUserAdmin(userDetails.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN")))
                .message("Login Succeed :)")
                .build();
    }
}
