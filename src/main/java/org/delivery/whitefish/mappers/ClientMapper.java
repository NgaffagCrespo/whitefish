package org.delivery.whitefish.mappers;

import org.delivery.whitefish.dtos.ClientDtoRequest;
import org.delivery.whitefish.dtos.ClientDtoResponse;
import org.delivery.whitefish.entities.Client;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    // De clientrequest vers client
    Client FromDtoClientRequest_ToClient(ClientDtoRequest clientDtoRequest);

    // de client vers client response
    ClientDtoResponse FromClient_ToDtoClientResponse(Client client);

}
