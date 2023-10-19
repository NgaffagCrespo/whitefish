package org.delivery.whitefish.web;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.delivery.whitefish.dtos.ClientDtoRequest;
import org.delivery.whitefish.dtos.ClientDtoResponse;
import org.delivery.whitefish.entities.Client;
import org.delivery.whitefish.services.ClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@NoArgsConstructor
@RequestMapping(path = "/deliveryWhiteFish")
public class ClientRestService {

    private ClientService clientService;

    @GetMapping(path = "/client/{name}")
   public ClientDtoResponse showClient(@PathVariable String name){
        return clientService.getClient(name);
    }

    @GetMapping(path = "/client")
   public List<ClientDtoResponse> AllClients(){
        return clientService.AllClients();
    }

    @PostMapping(path = "/client")
   public Client storeClient(Client client){
        return clientService.save(client);
    }

}
