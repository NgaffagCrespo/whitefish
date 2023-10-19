package org.delivery.whitefish.services;

import org.delivery.whitefish.dtos.ClientDtoRequest;
import org.delivery.whitefish.dtos.ClientDtoResponse;
import org.delivery.whitefish.entities.Client;

import java.util.List;

public interface ClientService {
    Client save(Client client);

    ClientDtoResponse getClient(String name);

    List<ClientDtoResponse> AllClients();
}
