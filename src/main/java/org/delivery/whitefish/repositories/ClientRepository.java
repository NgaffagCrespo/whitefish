package org.delivery.whitefish.repositories;

import org.delivery.whitefish.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, String> {

    Client findByName(String name);

}
