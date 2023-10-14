package org.delivery.whitefish.repositories;

import org.delivery.whitefish.entities.Bills;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<Bills, String> {
    
}
