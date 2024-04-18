package org.jeslorlim.modelojpa.repositories;

import org.jeslorlim.modelojpa.model.entities.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProyectoRepository extends JpaRepository<Proyecto, UUID> {
    @Query("select p.id from Proyecto p where p.nombre = ?1")
    UUID findIdByNombre(String nombre);
}