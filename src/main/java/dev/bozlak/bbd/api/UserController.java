package dev.bozlak.bbd.api;

import dev.bozlak.bbd.dtos.user.*;
import dev.bozlak.bbd.service.abstracts.UserService;
import dev.bozlak.core.responses.ResponseBody;
import dev.bozlak.core.responses.ResponseBodyWithObject;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<ResponseBody> addUser(@RequestBody @Valid AddUserRequestDto addUserRequestDto){
        this.userService.add(addUserRequestDto);
        return new ResponseEntity<>(
                new ResponseBody(true),
                HttpStatus.CREATED
        );
    }

    @PostMapping("/get-store-id-by-user-id")
    public ResponseEntity<ResponseBodyWithObject<Integer>> getStoreIdByUserId(@RequestBody Integer userId){
        return new ResponseEntity<>(
                new ResponseBodyWithObject<>(this.userService.getStoreIdByUserId(userId)),
                HttpStatus.OK
        );
    }

    @PostMapping("/change-password")
    public ResponseEntity<ResponseBody> changePassword(@RequestBody ChangePasswordRequestDto changePasswordRequestDto){
        this.userService.changePassword(changePasswordRequestDto);
        return new ResponseEntity<>(
                new ResponseBody(true),
                HttpStatus.OK
        );
    }

    @GetMapping("/is-user-a-bbd-tracker/{userId}")
    public ResponseEntity<ResponseBodyWithObject<IsBbdTrackerAndBbdTrackerResponseDto>> isUserABbdTracker(
            @PathVariable("userId") Integer userId
    ){
        return new ResponseEntity<>(
                new ResponseBodyWithObject<>(this.userService.isUserBbdTracker(userId)),
                HttpStatus.OK
        );
    }

    @GetMapping("/get-user-id-and-code-list")
    public ResponseEntity<ResponseBodyWithObject<List<UserIdAndCodeForAddUserByTrackerResponseDto>>> getUserIdAndCodeForAddUserByTrackerResponseDtoList(){
        return new ResponseEntity<>(
                new ResponseBodyWithObject<>(this.userService.getUserIdAndCodeForAddUserByTrackerResponseDtoList()),
                HttpStatus.OK
        );
    }

    @PutMapping("/add-store-to-user-by-bbd-tracker")
    public ResponseEntity<ResponseBody> addStoreToUserByBbdTracker(@RequestBody AddStoreToUserRequestDto addStoreToUserRequestDto){
        this.userService.addStoreToUser(addStoreToUserRequestDto);
        return new ResponseEntity<>(
                new ResponseBody(true),
                HttpStatus.OK
        );
    }

    @PostMapping("/get-user-id-and-code-list-without-himself")
    public ResponseEntity<ResponseBodyWithObject<List<UserIdAndCodeForAddUserByTrackerResponseDto>>> getUserIdAndCodeForAddUserByTrackerResponseDtoList(
            @RequestBody RequestDtoForListCoworkers requestDtoForListCoworkers
    ){
        return new ResponseEntity<>(
                new ResponseBodyWithObject<>(this.userService.getUserIdAndCodeForAddUserByTrackerResponseDtoList(requestDtoForListCoworkers)),
                HttpStatus.OK
        );
    }

    @PutMapping("/remove-user-from-store-by-bbd-tracker")
    public ResponseEntity<ResponseBody> removeUserFromStoreByBbdTracker(@RequestBody AddStoreToUserRequestDto addStoreToUserRequestDto){
        this.userService.removeUserFromStoreByBbdTracker(addStoreToUserRequestDto);
        return new ResponseEntity<>(
                new ResponseBody(true),
                HttpStatus.OK
        );
    }
}
