package org.delivery.whitefish.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClientDtoRequest {

    private String tel;
    private String email;
    private String localisation;
    private String name;

}
