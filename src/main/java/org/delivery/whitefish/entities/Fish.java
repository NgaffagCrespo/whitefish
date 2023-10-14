package org.delivery.whitefish.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;


@Data @Entity
@AllArgsConstructor @NoArgsConstructor
public class Fish {

    @Id
    private String id;
    private Long unit_price;
    private int quantity;
    private String name;

    // Relation many to many avec les factures
    @ManyToMany(mappedBy = "fishList",fetch = FetchType.LAZY)
    private List<Bills> bills;

}
