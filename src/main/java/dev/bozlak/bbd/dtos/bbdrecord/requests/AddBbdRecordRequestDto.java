package dev.bozlak.bbd.dtos.bbdrecord.requests;

import dev.bozlak.core.entity.Dto;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddBbdRecordRequestDto extends Dto {

    @NotNull
    @Min(value = 0)
    private Integer userId;

    @NotNull
    @Min(value = 0)
    private Integer productId;

    @NotNull
    private LocalDate bestBeforeDate;

    @NotNull
    @Min(value = 0)
    private Short quantity;

    @NotNull
    @Min(value = 0)
    private Byte activityTypeId;
}
