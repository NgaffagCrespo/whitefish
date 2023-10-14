package org.delivery.whitefish.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor @Data
public class FishDtoRequest {

    private Long unit_price;
    private int quantity;
    private String name;

}
