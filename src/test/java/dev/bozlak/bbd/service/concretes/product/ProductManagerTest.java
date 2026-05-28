package dev.bozlak.bbd.service.concretes.product;

import dev.bozlak.bbd.dtos.product.requests.AddProductRequestDto;
import dev.bozlak.bbd.repository.baseabstracts.ProductRepository;
import dev.bozlak.bbd.service.abstracts.ProductLogService;
import dev.bozlak.bbd.utilities.mappers.ProductLogMapperForServiceLayer;
import dev.bozlak.bbd.utilities.models.productlog.AddProductLogModel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

// We use MockitoExtension to create fake objects
@ExtendWith(MockitoExtension.class)
class ProductManagerTest {

    // 1. Create fake dependencies (Mocks)
    @Mock
    private ProductRepository fakeProductRepository;

    @Mock
    private ProductLogService fakeProductLogService;

    @Mock
    private ProductLogMapperForServiceLayer fakeMapper;

    // 2. Put the fakes into the real ProductManager
    @InjectMocks
    private ProductManager manager;

    @Test
    void shouldAddProductAndSaveLogSuccessfully() {
        // --- 1. ARRANGE (Prepare the test) ---
        AddProductRequestDto requestDto = new AddProductRequestDto();
        AddProductLogModel logModel = new AddProductLogModel();

        // We give an instruction to the fake mapper:
        // "When I give you 'requestDto', you must return 'logModel'."
        when(fakeMapper.toProductLogModelFromAddProductRequestDto(requestDto)).thenReturn(logModel);

        // --- 2. ACT (Do the action) ---
        manager.add(requestDto);

        // --- 3. ASSERT (Check the results) ---
        // Step 1: Did the manager save the product to the repository?
        verify(fakeProductRepository, times(1)).save(requestDto);

        // Step 2: Did the manager use the mapper to convert the DTO?
        verify(fakeMapper, times(1)).toProductLogModelFromAddProductRequestDto(requestDto);

        // Step 3: Did the manager send the new logModel to the LogService?
        verify(fakeProductLogService, times(1)).add(logModel);
    }
}