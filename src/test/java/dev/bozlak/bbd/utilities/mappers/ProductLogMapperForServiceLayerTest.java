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

        dto.setProductName("Ülker Çikolatalı Gofret");
        dto.setProductCode("1234567");
        dto.setPrice(new BigDecimal("10.50"));

        dto.setBbdTrackerId(99);
        dto.setUserId(5);
        dto.setActivityTypeId((byte) 1);

        AddProductLogModel model = mapper.toProductLogModelFromAddProductRequestDto(dto);

        assertNotNull(model, "Dönen AddProductLogModel null olmamalıdır.");

        assertEquals(99, model.getBbdTrackerId(), "BbdTracker ID eşleşmiyor.");
        assertEquals(5, model.getUserId(), "User ID eşleşmiyor.");
        assertEquals((byte) 1, model.getActivityTypeId(), "ActivityType ID eşleşmiyor.");
    }

    @Test
    void shouldReturnNullWhenDtoIsNull() {

        AddProductLogModel model = mapper.toProductLogModelFromAddProductRequestDto(null);

        assertNull(model, "Gelen DTO null ise, sonuç da null dönmelidir.");
    }
}