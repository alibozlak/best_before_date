package dev.bozlak.bbd.utilities.mappers;

import dev.bozlak.bbd.dtos.product.requests.AddProductRequestDto;
import dev.bozlak.bbd.utilities.models.productlog.AddProductLogModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ProductLogMapperForServiceLayerTest {

    private ProductLogMapperForServiceLayer mapper;

    @BeforeEach
    void setUp() {
        mapper = Mappers.getMapper(ProductLogMapperForServiceLayer.class);
    }

    @Test
    void shouldFilterAndMapRequestDtoToModelSuccessfully() {

        AddProductRequestDto dto = new AddProductRequestDto();

        dto.setProductName("Chocolate Wafer");
        dto.setProductCode("1234567");
        dto.setPrice(new BigDecimal("10.50"));

        dto.setBbdTrackerId(99);
        dto.setUserId(5);
        dto.setActivityTypeId((byte) 1);

        AddProductLogModel model = mapper.toProductLogModelFromAddProductRequestDto(dto);

        assertNotNull(model, "The returned AddProductLogModel should not be null!");

        assertEquals(99, model.getBbdTrackerId(), "BbdTracker ID does not match!");
        assertEquals(5, model.getUserId(), "User ID does not match!");
        assertEquals((byte) 1, model.getActivityTypeId(), "ActivityType ID does not match!");
    }

    @Test
    void shouldReturnNullWhenDtoIsNull() {

        AddProductLogModel model = mapper.toProductLogModelFromAddProductRequestDto(null);

        assertNull(model, "If the input DTO is null, the result should be null.");
    }
}