package org.delivery.whitefish.repositories;

import org.delivery.whitefish.entities.Fish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FishRepository extends JpaRepository<Fish, String> {

    Fish findByName(String name);
}
