package dev.bozlak.bbd.api;

import dev.bozlak.bbd.dtos.user.AddUserRequestDto;
import dev.bozlak.bbd.service.abstracts.UserService;
import dev.bozlak.bbd.utilities.ProjectConstants;
import dev.bozlak.core.responses.ResponseBody;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseBody addUser(@RequestBody @Valid AddUserRequestDto addUserRequestDto){
        addUserRequestDto.setStoreId(ProjectConstants.MEVLANA_STORE_ID);
        this.userService.add(addUserRequestDto);
        return new ResponseBody(true);
    }
}
