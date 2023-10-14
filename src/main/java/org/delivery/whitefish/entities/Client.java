package org.delivery.whitefish.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Client {

    @Id
    private String id;
    private String tel;
    private String email;
    private String localisation;
    private String name;

    // Relation one to many avec les factures
    @OneToMany(mappedBy = "client",fetch = FetchType.LAZY)
    private List<Bills> bills;

    // Relation one to many avec les mails
    @OneToMany(mappedBy = "client",fetch = FetchType.LAZY)
    private List<EmailDelivery> emailDeliveries;

}
