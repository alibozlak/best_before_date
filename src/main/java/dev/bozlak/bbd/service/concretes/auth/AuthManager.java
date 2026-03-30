package dev.bozlak.bbd.service.concretes.auth;

import dev.bozlak.bbd.dtos.auth.AuthResponseDto;
import dev.bozlak.bbd.dtos.user.LoginRequestDto;
import dev.bozlak.bbd.service.abstracts.ActivityTypeService;
import dev.bozlak.bbd.service.abstracts.AuthService;
import dev.bozlak.bbd.service.abstracts.UserService;
import dev.bozlak.bbd.utilities.security.CustomUserDetailsService;
import dev.bozlak.bbd.utilities.security.JwtManager;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthManager implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final CustomUserDetailsService customUserDetailsService;
    private final JwtManager jwtManager;
    private final UserService userService;
    private final ActivityTypeService activityTypeService;

    @Override
    public AuthResponseDto login(LoginRequestDto loginRequestDto){
        final String userName = loginRequestDto.getUserName();
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userName, loginRequestDto.getPassword())
        );

        UserDetails userDetails = this.customUserDetailsService.loadUserByUsername(userName);

        String jwtToken = this.jwtManager.generateToken(userDetails);

        Integer userId = this.userService.getUserIdByUsername(userName);

        return AuthResponseDto.builder()
                .accessToken(jwtToken)
                .isUserAdmin(userDetails.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN")))
                .userId(userId)
                .activityTypes(this.activityTypeService.getAllActivityType())
                .build();
    }
}
