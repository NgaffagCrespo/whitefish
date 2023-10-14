package org.delivery.whitefish.web;


import lombok.AllArgsConstructor;
import org.delivery.whitefish.dtos.FishDtoRequest;
import org.delivery.whitefish.dtos.FishDtoResponse;
import org.delivery.whitefish.services.FishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/deliveryWhiteFish")
public class FishRestService {


    private FishService fishService;

    @GetMapping(path = "/fish")
    public List<FishDtoResponse> AllFish(){
        return fishService.AllFish();
    }

    @GetMapping(path = "/fish/{name}")
        public FishDtoResponse showFish(@PathVariable String name){
            return fishService.getFish(name);
        }

        @PostMapping(path = "/fish")
    public FishDtoResponse storeFish(FishDtoRequest fishDtoRequest){
       return fishService.save(fishDtoRequest);
        }


}
