package org.delivery.whitefish.services;

import lombok.AllArgsConstructor;
import org.delivery.whitefish.dtos.ClientDtoRequest;
import org.delivery.whitefish.dtos.ClientDtoResponse;
import org.delivery.whitefish.entities.Client;
import org.delivery.whitefish.mappers.ClientMapper;
import org.delivery.whitefish.repositories.ClientRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class ClientServiceImpl implements ClientService {

    private ClientRepository clientRepository;

    private ClientMapper clientMapper;


    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client save(Client client) {

        client.setId(UUID.randomUUID().toString());

        Client savedClient = clientRepository.save(client);

        return savedClient;
    }

    @Override
    public ClientDtoResponse getClient(String name) {

        Client client = clientRepository.findByName(name);
        ClientDtoResponse clientDtoResponse = clientMapper.FromClient_ToDtoClientResponse(client);

        return clientDtoResponse;
    }

    @Override
    public List<ClientDtoResponse> AllClients() {

        List<Client> clientList = clientRepository.findAll();

        return clientList
                .stream()
                .map(client -> clientMapper.FromClient_ToDtoClientResponse(client)).collect(Collectors.toList());
    }
}
