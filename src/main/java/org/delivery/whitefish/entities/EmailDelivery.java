package org.delivery.whitefish.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class EmailDelivery {

    @Id
    private String id;
    private String subject;
    private String body;
    private String toemail;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
}
