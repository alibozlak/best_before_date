package dev.bozlak.bbd.utilities.mappers;

import dev.bozlak.bbd.dtos.bbdrecord.requests.*;
import dev.bozlak.bbd.entities.UserActivity;
import dev.bozlak.bbd.utilities.models.useractivity.AddUserActivityModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserActivityMapper {

    UserActivity toUserActivityFromAddUserActivityModel(AddUserActivityModel addUserActivityModel);


    // ------------- Mapping For AddUserActivityModel ------------------------

    AddUserActivityModel toAddUserActivityModelFromAddBbdRecordRequestDto(
            AddBbdRecordRequestDto addBbdRecordRequestDto
    );

    AddUserActivityModel toAddUserActivityModelFromUpdateBbdRecordRequestDto(
            UpdateBbdRecordRequestDto updateBbdRecordRequestDto
    );
}
