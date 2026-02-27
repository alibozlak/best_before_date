package dev.bozlak.bbd.service.concretes.user;

import dev.bozlak.bbd.dtos.user.AddUserRequestDto;
import dev.bozlak.bbd.entities.User;
import dev.bozlak.bbd.repository.UserRepository;
import dev.bozlak.bbd.service.abstracts.UserService;
import dev.bozlak.bbd.utilities.mappers.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FirstUserService implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public void add(AddUserRequestDto addUserRequestDto) {
        User user = this.userMapper.toEntity(addUserRequestDto);
        this.userRepository.save(user);
    }
}
