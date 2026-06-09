package dev.bozlak.bbd.api;

import dev.bozlak.bbd.dtos.user.*;
import dev.bozlak.bbd.service.abstracts.UserService;
import dev.bozlak.core.responses.ResponseBody;
import dev.bozlak.core.responses.ResponseBodyWithObject;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@Tag(name = "User Management", description = "Endpoints for managing staff members, roles, and store assignments.")
public class UserController {

    private final UserService userService;

    @PostMapping
    @Operation(summary = "Register a new user", description = "Creates a new user account. (For BBD Tracker or Admin)")
    public ResponseEntity<ResponseBody> addUser(@RequestBody @Valid AddUserRequestDto addUserRequestDto){
        this.userService.add(addUserRequestDto);
        return new ResponseEntity<>(
                new ResponseBody(true),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/get-store-id-by-user-id/{userId}")
    @Operation(summary = "Get user's store ID", description = "Retrieves the store ID assigned to a specific user.")
    public ResponseEntity<ResponseBodyWithObject<Integer>> getStoreIdByUserId(@PathVariable("userId") Integer userId){
        return new ResponseEntity<>(
                new ResponseBodyWithObject<>(this.userService.getStoreIdByUserId(userId)),
                HttpStatus.OK
        );
    }

    @PostMapping("/change-password")
    @Operation(summary = "Change User Password", description = "Allows a user to securely change their password.")
    public ResponseEntity<ResponseBody> changePassword(@RequestBody ChangePasswordRequestDto changePasswordRequestDto){
        this.userService.changePassword(changePasswordRequestDto);
        return new ResponseEntity<>(
                new ResponseBody(true),
                HttpStatus.OK
        );
    }

    @GetMapping("/is-user-a-bbd-tracker/{userId}")
    @Operation(
            summary = "Check BBD Tracker status",
            description = "Checks if the specified user has BBD Tracker privileges."
    )
    public ResponseEntity<ResponseBodyWithObject<IsBbdTrackerAndBbdTrackerResponseDto>> isUserABbdTracker(
            @PathVariable("userId") Integer userId
    ){
        return new ResponseEntity<>(
                new ResponseBodyWithObject<>(this.userService.isUserBbdTracker(userId)),
                HttpStatus.OK
        );
    }

    @GetMapping("/get-user-id-and-code-list")
    @Operation(
            summary = "Get unassigned users",
            description = "Retrieves a list of users who are not currently assigned to a store."
    )
    public ResponseEntity<ResponseBodyWithObject<List<UserIdAndCodeForAddUserByTrackerResponseDto>>>
            getUserIdAndCodeForAddUserByTrackerResponseDtoList(){
        return new ResponseEntity<>(
                new ResponseBodyWithObject<>(this.userService.getUserIdAndCodeForAddUserByTrackerResponseDtoList()),
                HttpStatus.OK
        );
    }

    @PutMapping("/add-store-to-user-by-bbd-tracker")
    @Operation(summary = "Assign store to user", description = "Assigns a specific store to a user by a BBD Tracker.")
    public ResponseEntity<ResponseBody> addStoreToUserByBbdTracker(@RequestBody AddStoreToUserRequestDto addStoreToUserRequestDto){
        this.userService.addStoreToUser(addStoreToUserRequestDto);
        return new ResponseEntity<>(
                new ResponseBody(true),
                HttpStatus.OK
        );
    }

    @PostMapping("/get-user-id-and-code-list-without-himself")
    @Operation(
            summary = "Get co-workers",
            description = "Retrieves a list of users assigned to the same store, excluding the requesting user."
    )
    public ResponseEntity<ResponseBodyWithObject<List<UserIdAndCodeForAddUserByTrackerResponseDto>>> getUserIdAndCodeForAddUserByTrackerResponseDtoList(
            @RequestBody RequestDtoForListCoworkers requestDtoForListCoworkers
    ){
        return new ResponseEntity<>(
                new ResponseBodyWithObject<>(this.userService.getUserIdAndCodeForAddUserByTrackerResponseDtoList(requestDtoForListCoworkers)),
                HttpStatus.OK
        );
    }

    @PutMapping("/remove-user-from-store-by-bbd-tracker")
    @Operation(summary = "Remove user from store", description = "Revokes a user's store assignment.")
    public ResponseEntity<ResponseBody> removeUserFromStoreByBbdTracker(@RequestBody AddStoreToUserRequestDto addStoreToUserRequestDto){
        this.userService.removeUserFromStoreByBbdTracker(addStoreToUserRequestDto);
        return new ResponseEntity<>(
                new ResponseBody(true),
                HttpStatus.OK
        );
    }
}
