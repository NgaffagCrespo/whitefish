package org.delivery.whitefish.services;

import org.delivery.whitefish.dtos.FishDtoRequest;
import org.delivery.whitefish.dtos.FishDtoResponse;
import org.delivery.whitefish.entities.Fish;
import org.delivery.whitefish.mappers.FishMapper;
import org.delivery.whitefish.repositories.FishRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class FishServiceImpl implements FishService {

    private FishRepository fishRepository;
    private FishMapper fishMapper;

    public FishServiceImpl(FishRepository fishRepository, FishMapper fishMapper) {
        this.fishRepository = fishRepository;
        this.fishMapper = fishMapper;
    }

    @Override
    public FishDtoResponse save(FishDtoRequest fishDtoRequest) {

        // Ici nous allons mapper fishDtoRequest en fish enfin de pouvoir le save
        Fish fish = fishMapper.FromDtoFishRequest_ToFish(fishDtoRequest);

        //ici nous allons generer un mode de passe aleatoire pour fish
        fish.setId(UUID.randomUUID().toString());

        // Ici on sauvegarde fish
        Fish savedFish = fishRepository.save(fish);

        //Ici nous allons mapper de nouveau fishsaved vers fishDtoResponse pour une response
        FishDtoResponse fishDtoResponse = fishMapper.FromFish_ToFishResponseDto(savedFish);

        return fishDtoResponse;
    }

    @Override
    public FishDtoResponse getFish(String nom)
    {

        //Ici on recupere fish correspondant au nom donne en parametre
        Fish fish = fishRepository.findByName(nom);

        //Ici on converti en fishdtoResponse pour avoir une reponse
        FishDtoResponse fishDtoResponse = fishMapper.FromFish_ToFishResponseDto(fish);

        return null;
    }

    @Override
    public List<FishDtoResponse> AllFish() {

        /*
        * On recupere tous les fish puis on les met dans une
        * stream map pour les bien afficher en tant que collection
        * */
        List<Fish> fishList = fishRepository.findAll();

        return fishList
                .stream()
                .map(fish -> fishMapper.FromFish_ToFishResponseDto(fish)).collect(Collectors.toList());
    }
}
