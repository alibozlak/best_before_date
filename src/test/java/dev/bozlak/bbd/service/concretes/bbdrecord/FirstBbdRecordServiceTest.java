package dev.bozlak.bbd.service.concretes.bbdrecord;

import dev.bozlak.bbd.dtos.bbdrecord.AddBbdRecordRequestDto;
import dev.bozlak.bbd.entities.BbdRecord;
import dev.bozlak.bbd.entities.Product;
import dev.bozlak.bbd.entities.Store;
import dev.bozlak.bbd.entities.User;
import dev.bozlak.bbd.repository.BbdRecordRepository;
import dev.bozlak.bbd.service.abstracts.ProductService;
import dev.bozlak.bbd.service.abstracts.UserActivityService;
import dev.bozlak.bbd.service.abstracts.UserService;
import dev.bozlak.bbd.utilities.mappers.BbdRecordMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FirstBbdRecordServiceTest {

    @Mock
    private BbdRecordRepository bbdRecordRepository;

    @Mock
    private BbdRecordMapper bbdRecordMapper;

    @Mock
    private UserService userService;

    @Mock
    private ProductService productService;

    @Mock
    private UserActivityService userActivityService;

    @InjectMocks
    private FirstBbdRecordService firstBbdRecordService;

    @Test
    void add_whenProductIdDoesNotExist_shouldThrowRuntimeException(){
        // ARRANGE :
        AddBbdRecordRequestDto addBbdRecordRequestDto = new AddBbdRecordRequestDto();
        addBbdRecordRequestDto.setProductId(99);
        addBbdRecordRequestDto.setUserId(1);

        when(productService.doesExistProductIdGivenNumber(99)).thenReturn(false);

        // ACT & ASSERT :
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            firstBbdRecordService.add(addBbdRecordRequestDto);
        });

        assertEquals(
                "Doesn't exist record in products table given number for product id!!",
                exception.getMessage()
        );

        verify(bbdRecordRepository,never()).save(any());
    }

    @Test
    void add_whenUserIdDoesNotExist_shouldThrowRuntimeException(){
        AddBbdRecordRequestDto addBbdRecordRequestDto = new AddBbdRecordRequestDto();
        addBbdRecordRequestDto.setUserId(12);
        addBbdRecordRequestDto.setProductId(1);

        when(productService.doesExistProductIdGivenNumber(1)).thenReturn(true);
        when(userService.doesExistUserIdGivenNumber(12)).thenReturn(false);

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            firstBbdRecordService.add(addBbdRecordRequestDto);
        });

        assertEquals(
                "Doesn't exist record in users table given number for user id!!",
                exception.getMessage()
        );

        verify(bbdRecordRepository, never()).save(any());
    }

    @Test
    void add_addBbdRecordDtosAllFieldsCorrect_shouldCallBbdRepositoryOnce(){
        LocalDate localDate = LocalDate.of(2026,3,12);
        AddBbdRecordRequestDto addBbdRecordRequestDto =
                new AddBbdRecordRequestDto(1,1,localDate,(short)4, (byte)1);
        when(productService.doesExistProductIdGivenNumber(1)).thenReturn(true);
        when(userService.doesExistUserIdGivenNumber(1)).thenReturn(true);
        BbdRecord bbdRecord = new BbdRecord(
                null,
                new User(1,
                        "bozlak",
                        "bozlak123",
                        new Store(1, "Mevlana-Bornova","D377"),
                        true
                ),
                new Product(1, "Mantar 400 g", "1000206", (short)2, BigDecimal.valueOf(69.00), (short)1),
                localDate,
                (short)4
        );
        when(bbdRecordMapper.fromAddBbdRecordRequestDtoToBbdRecordEntity(addBbdRecordRequestDto))
                .thenReturn(bbdRecord);

        firstBbdRecordService.add(addBbdRecordRequestDto);

        verify(bbdRecordRepository, times(1)).save(bbdRecord);
    }

}
