package org.delivery.whitefish.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.delivery.whitefish.entities.Bills;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FishDtoResponse {

    private String id;
    private Long unit_price;
    private int quantity;
    private String name;
    private List<Bills> bills;

}
