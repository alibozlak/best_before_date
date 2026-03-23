package dev.bozlak.bbd.service.concretes.user;

import dev.bozlak.bbd.repository.baseabstracts.UserRepository;
import dev.bozlak.bbd.utilities.exceptions.user.UserNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FirstUserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private FirstUserService firstUserService;

    @Test
    void deleteById_ifExistUserIdShouldCallUserRepositoryOnce(){
        Integer userIdRequest = 1;
        when(userRepository.existsById(userIdRequest)).thenReturn(true);

        this.firstUserService.deleteUserById(userIdRequest);

        verify(userRepository,times(1)).deleteById(userIdRequest);
    }

    @Test
    void deleteById_ifDoesNotExistUserIdShouldThrowUserNotFoundException(){
        Integer userIdRequest = 12;
        when(userRepository.existsById(userIdRequest)).thenReturn(false);

        assertThrows(
                UserNotFoundException.class,
                () -> this.firstUserService.deleteUserById(userIdRequest)
        );
        verify(this.userRepository, never()).deleteById(userIdRequest);
    }
}
