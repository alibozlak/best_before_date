package dev.bozlak.bbd.repository.implementations.jpa.mappers;

import dev.bozlak.bbd.repository.implementations.jpa.entities.ProductLog;
import dev.bozlak.bbd.utilities.models.productlog.AddProductLogModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.*;

class ProductLogMapperForJpaTest {

    // We do not need Spring context. We use the Impl class that MapStruct creates.
    private ProductLogMapperForJpa mapper;

    @BeforeEach
    void setUp() {
        mapper = Mappers.getMapper(ProductLogMapperForJpa.class);
    }

    @Test
    void shouldMapAddProductLogModelToProductLogJpaEntitySuccessfully() {
        // 1. Arrange - Prepare the incoming data (Model)
        AddProductLogModel model = new AddProductLogModel();
        model.setBbdTrackerId(15);
        model.setUserId(7);
        model.setActivityTypeId((byte) 2);

        // 2. Act - Run the mapper
        ProductLog entity = mapper.toProductLogJpaEntityFromAddProductLogModel(model);

        // 3. Assert - Check the results
        assertNotNull(entity, "ProductLog entity should not be null.");

        // Check if the nested objects are created and have the correct IDs
        assertNotNull(entity.getBbdTracker(), "BbdTracker object should be created.");
        assertEquals(15, entity.getBbdTracker().getId(), "BbdTracker ID does not match.");

        assertNotNull(entity.getUser(), "User object should be created.");
        assertEquals(7, entity.getUser().getId(), "User ID does not match.");

        assertNotNull(entity.getActivityType(), "ActivityType object should be created.");
        assertEquals((byte) 2, entity.getActivityType().getId(), "ActivityType ID does not match.");
    }

    @Test
    void shouldReturnNullWhenModelIsNull() {
        // 1. Arrange & Act
        // We test MapStruct's default Null Safety feature.
        ProductLog entity = mapper.toProductLogJpaEntityFromAddProductLogModel(null);

        // 2. Assert
        assertNull(entity, "If the incoming model is null, the mapper should return null.");
    }
}