package dev.bozlak.bbd.service.concretes.user;

import dev.bozlak.bbd.dtos.user.AddUserRequestDto;
import dev.bozlak.bbd.entities.User;
import dev.bozlak.bbd.repository.baseabstracts.UserRepository;
import dev.bozlak.bbd.service.abstracts.UserService;
import dev.bozlak.bbd.utilities.exceptions.user.UserNotFoundException;
import dev.bozlak.bbd.utilities.mappers.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

@RequiredArgsConstructor
public class UserManager implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void add(AddUserRequestDto addUserRequestDto) {
        User user = this.userMapper.toEntity(addUserRequestDto);
        String hashedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);
        user.setStoreId(addUserRequestDto.getStoreId());
        this.userRepository.add(user);
    }

    @Override
    public boolean doesExistUserIdGivenNumber(Integer userId) {
        return this.userRepository.existsById(userId);
    }

    @Override
    public void deleteUserById(Integer id) {
        if (this.doesExistUserIdGivenNumber(id)){
            this.userRepository.deleteById(id);
        } else {
            throw new UserNotFoundException(id);
        }
    }

    @Override
    public Integer getUserIdByUsername(String username) {
        return this.userRepository.findUserIdByUsername(username);
    }

    @Override
    public Integer getStoreIdByUserId(Integer userId) {
        return this.userRepository.findStoreIdByUserId(userId);
    }
}
