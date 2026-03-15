package dev.bozlak.bbd.utilities.mappers;

import dev.bozlak.bbd.dtos.bbdrecord.AddBbdRecordRequestDto;
import dev.bozlak.bbd.entities.BbdRecord;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class BbdRecordMapperTest {

    private final BbdRecordMapper bbdRecordMapper = new BbdRecordMapperImpl();

    @Test
    void fromAddBbdRecordRequestDtoToBbdRecordEntity_isSuccess(){
        LocalDate localDate = LocalDate.of(2026,3,8);
        AddBbdRecordRequestDto addBbdRecordRequestDto
                = new AddBbdRecordRequestDto(1, 1, localDate, (short)4, (byte)1);

        BbdRecord bbdRecord = bbdRecordMapper.fromAddBbdRecordRequestDtoToBbdRecordEntity(addBbdRecordRequestDto);

        assertEquals(1, bbdRecord.getProduct().getId());
        assertEquals(1, bbdRecord.getUser().getId());
        assertEquals(localDate, bbdRecord.getBestBeforeDate());
        assertEquals((short)4, bbdRecord.getQuantity());
        assertNull(bbdRecord.getId());
    }
}
