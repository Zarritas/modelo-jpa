package org.jeslorlim.modelojpa.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@AllArgsConstructor @NoArgsConstructor @Data
public class EstudianteEdicion {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private int nota;

    @ManyToOne
    @JoinColumn(
            name = "id_empleado",
            foreignKey = @ForeignKey(name = "FK_estudiante_edicion_empleado_empleado")
    )
    private Empleado empleado;
    @ManyToOne
    @JoinColumn(
            name = "id_edicion",
            foreignKey = @ForeignKey(name = "FK_estudiante_edicion_edicion_edicion")
    )
    private Edicion edicion;
}
