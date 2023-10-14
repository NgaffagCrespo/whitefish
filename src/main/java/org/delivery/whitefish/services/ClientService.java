package org.delivery.whitefish.services;

import org.delivery.whitefish.dtos.ClientDtoRequest;
import org.delivery.whitefish.dtos.ClientDtoResponse;

import java.util.List;

public interface ClientService {
    ClientDtoResponse save(ClientDtoRequest clientDtoRequest);

    ClientDtoResponse getClient(String name);

    List<ClientDtoResponse> AllClients();
}
