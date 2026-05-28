package dev.bozlak.bbd.service.concretes.productlog;

import dev.bozlak.bbd.repository.baseabstracts.ProductLogRepository;
import dev.bozlak.bbd.utilities.models.productlog.AddProductLogModel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

// We use MockitoExtension to make fake objects easily.
@ExtendWith(MockitoExtension.class)
class ProductLogManagerTest {

    // 1. Create a fake Repository
    @Mock
    private ProductLogRepository fakeRepository;

    // 2. Put the fake Repository into the real Manager
    @InjectMocks
    private ProductLogManager manager;

    @Test
    void shouldCallRepositoryAddMethodSuccessfully() {
        // Arrange (Prepare)
        AddProductLogModel model = new AddProductLogModel();
        model.setUserId(5);

        // Act (Do the action)
        manager.add(model);

        // Assert (Check the result)
        // Did the manager call the fake repository's add method exactly one time?
        verify(fakeRepository, times(1)).add(model);
    }
}