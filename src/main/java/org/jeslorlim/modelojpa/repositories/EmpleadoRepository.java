package org.jeslorlim.modelojpa.repositories;

import org.jeslorlim.modelojpa.model.enbedded.Persona;
import org.jeslorlim.modelojpa.model.entities.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, UUID> {
    Empleado findByPersona(Persona persona);
}
