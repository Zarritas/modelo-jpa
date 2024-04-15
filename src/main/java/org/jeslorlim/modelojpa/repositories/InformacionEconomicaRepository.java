package org.jeslorlim.modelojpa.repositories;

import org.jeslorlim.modelojpa.model.entities.InformacionEconomica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface InformacionEconomicaRepository extends JpaRepository<InformacionEconomica, UUID> {
}
