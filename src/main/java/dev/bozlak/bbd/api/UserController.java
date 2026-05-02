package dev.bozlak.bbd.api;

import dev.bozlak.bbd.dtos.user.AddUserRequestDto;
import dev.bozlak.bbd.dtos.user.ChangePasswordRequestDto;
import dev.bozlak.bbd.service.abstracts.UserService;
import dev.bozlak.core.responses.ResponseBody;
import dev.bozlak.core.responses.ResponseBodyWithObject;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseBody addUser(@RequestBody @Valid AddUserRequestDto addUserRequestDto){
        this.userService.add(addUserRequestDto);
        return new ResponseBody(true);
    }

    @PostMapping("/get-store-id-by-user-id")
    public ResponseBodyWithObject<Integer> getStoreIdByUserId(@RequestBody Integer userId){
        return new ResponseBodyWithObject<>(this.userService.getStoreIdByUserId(userId));
    }

    @PostMapping("/change-password")
    public ResponseBody changePassword(@RequestBody ChangePasswordRequestDto changePasswordRequestDto){
        this.userService.changePassword(changePasswordRequestDto);
        return new ResponseBody(true);
    }

    @GetMapping("/is-user-a-bbd-tracker/{userId}")
    public ResponseBody isUserABbdTracker(@PathVariable("userId") Integer userId){
        return new ResponseBody(this.userService.isUserBbdTracker(userId));
    }
}
