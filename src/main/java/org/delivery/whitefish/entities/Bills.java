package org.delivery.whitefish.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Bills {

    @Id
    private String id;
    private Long amount;
    private Date date_bill;

    // Relation many to many avec les poissons
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "bill_fish")
    private List<Fish> fishList;

    // Relation one to many avec les clients
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;


}
