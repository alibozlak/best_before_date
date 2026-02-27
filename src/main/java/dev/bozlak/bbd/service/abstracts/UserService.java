package dev.bozlak.bbd.service.abstracts;

import dev.bozlak.bbd.dtos.user.AddUserRequestDto;

public interface UserService {
    void add(AddUserRequestDto addUserRequestDto);
}
