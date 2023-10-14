package org.delivery.whitefish.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.delivery.whitefish.entities.Bills;
import org.delivery.whitefish.entities.EmailDelivery;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClientDtoResponse {

    private String id;
    private String tel;
    private String email;
    private String localisation;
    private String name;

    private List<Bills> bills;
    private List<EmailDelivery> emailDeliveries;

}
