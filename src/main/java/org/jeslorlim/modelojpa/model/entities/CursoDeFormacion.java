package org.jeslorlim.modelojpa.model.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;
import java.util.UUID;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class CursoDeFormacion {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String nombre;
    private int duracion;

    @OneToMany
    @JoinColumn(
            foreignKey = @ForeignKey(name = "FK_curso_de_formacion_ediciones")
    )
    private Set<Edicion> ediciones;

    @OneToMany
    @JoinColumn(
            foreignKey = @ForeignKey(name = "FK_curso_de_formacion_empleados_capacitados")
    )
    private Set<Empleado> empleadosCapacitados;
}
