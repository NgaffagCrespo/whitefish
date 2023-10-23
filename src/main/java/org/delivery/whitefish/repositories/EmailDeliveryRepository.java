package org.delivery.whitefish.repositories;

import org.delivery.whitefish.entities.EmailDelivery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailDeliveryRepository extends JpaRepository<EmailDelivery,String> {
}
