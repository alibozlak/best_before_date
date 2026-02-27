package dev.bozlak.bbd.api;

import dev.bozlak.bbd.dtos.user.AddUserRequestDto;
import dev.bozlak.bbd.service.abstracts.UserService;
import dev.bozlak.bbd.utilities.ProjectConstants;
import dev.bozlak.bbd.utilities.StringUtility;
import dev.bozlak.core.responses.ResponseBody;
import dev.bozlak.core.responses.ResponseBodyWithMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseBody addUser(@RequestBody AddUserRequestDto addUserRequestDto){
        try {
            if (!StringUtility.isStringNotNullAndNotEmpty(addUserRequestDto.getUserName()))
                throw new RuntimeException("userName must be not null or empty!!");
            if (!StringUtility.isStringNotNullAndNotEmpty(addUserRequestDto.getPassword()))
                throw new RuntimeException("password must be not null or empty");
            addUserRequestDto.setStoreId(ProjectConstants.MEVLANA_STORE_ID);
            this.userService.add(addUserRequestDto);
            return new ResponseBody(true);
        } catch (Exception e) {
            return new ResponseBodyWithMessage(false, e.getMessage());
        }
    }
}
