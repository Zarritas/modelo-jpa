package org.jeslorlim.modelojpa.repositories;

import org.jeslorlim.modelojpa.model.entities.GrupoDeDesarrollo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface GrupoDeDesarrolloRepository extends JpaRepository<GrupoDeDesarrollo, UUID> {
}
