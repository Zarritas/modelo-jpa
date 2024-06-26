package org.jeslorlim.modelojpa.repositories;

import org.jeslorlim.modelojpa.model.entities.Nomina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface NominaRepository extends JpaRepository<Nomina, UUID> {
}
