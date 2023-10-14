package org.delivery.whitefish.mappers;


import org.delivery.whitefish.dtos.FishDtoRequest;
import org.delivery.whitefish.dtos.FishDtoResponse;
import org.delivery.whitefish.entities.Fish;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FishMapper {

    // Methode qui fera l'injection des dependances de fishDtoRequest vers Fish
    Fish FromDtoFishRequest_ToFish(FishDtoRequest fishDtoRequest);

    //Methode qui fera l'injection de dependances de fish vers fishResponseDto
    FishDtoResponse FromFish_ToFishResponseDto(Fish fish);

}
