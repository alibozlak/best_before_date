package dev.bozlak.bbd.utilities.security;

import dev.bozlak.bbd.entities.User;
import dev.bozlak.bbd.repository.baseabstracts.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = this.userRepository.findByUserName(userName)
                .orElseThrow(() -> new UsernameNotFoundException("This userName not found in system : " + userName));
        String role = "USER";
        if (user.getIsAdmin()) {
            role = "ADMIN";
        }

        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getUserName())
                .password(user.getPassword())
                .roles(role)
                .build();
    }
}
