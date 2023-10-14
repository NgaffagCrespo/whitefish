package org.delivery.whitefish.services;

import org.delivery.whitefish.dtos.FishDtoRequest;
import org.delivery.whitefish.dtos.FishDtoResponse;

import java.util.List;

public interface FishService {

    FishDtoResponse save(FishDtoRequest fishDtoRequest);

    FishDtoResponse getFish(String nom);

    List<FishDtoResponse> AllFish();

}
