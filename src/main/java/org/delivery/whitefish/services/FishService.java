package org.delivery.whitefish.services;

import org.delivery.whitefish.dtos.FishDtoRequest;
import org.delivery.whitefish.dtos.FishDtoResponse;
import org.delivery.whitefish.entities.Fish;

import java.util.List;

public interface FishService {

    Fish save(Fish fish);

    FishDtoResponse getFish(String nom);

    List<FishDtoResponse> AllFish();

}
