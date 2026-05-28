package dev.bozlak.bbd.repository.implementations.jpa.productlog;

import dev.bozlak.bbd.repository.implementations.jpa.entities.ProductLog;
import dev.bozlak.bbd.repository.implementations.jpa.mappers.ProductLogMapperForJpa;
import dev.bozlak.bbd.utilities.models.productlog.AddProductLogModel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class JpaProductLogRepositoryAdapterTest {

    // 1. Create fake dependencies
    @Mock
    private JpaProductLogRepository fakeJpaRepository;

    @Mock
    private ProductLogMapperForJpa fakeMapper;

    // 2. Put fake dependencies into the real Adapter
    @InjectMocks
    private JpaProductLogRepositoryAdapter adapter;

    @Test
    void shouldMapModelToEntityAndSaveItSuccessfully() {
        // Arrange (Prepare)
        AddProductLogModel model = new AddProductLogModel();
        ProductLog entity = new ProductLog(); // We create an empty entity for the fake mapper to return.

        // Tell the fake mapper what to do:
        // "When I give you 'model', you must return 'entity'."
        when(fakeMapper.toProductLogJpaEntityFromAddProductLogModel(model)).thenReturn(entity);

        // Act (Do the action)
        adapter.add(model);

        // Assert (Check the result)
        // 1. Did the adapter use the mapper?
        verify(fakeMapper, times(1)).toProductLogJpaEntityFromAddProductLogModel(model);

        // 2. Did the adapter save the correct entity to the database?
        verify(fakeJpaRepository, times(1)).save(entity);
    }
}