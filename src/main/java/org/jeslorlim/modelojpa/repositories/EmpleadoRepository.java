package org.jeslorlim.modelojpa.repositories;

import org.jeslorlim.modelojpa.model.enbedded.Persona;
import org.jeslorlim.modelojpa.model.entities.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, UUID> {
    Empleado findByNombre(String nombre);

    @Query("select e.id from Empleado e where e.nombre = ?1")
    UUID findIdByNombre(String s);
}
