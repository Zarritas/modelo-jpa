package org.jeslorlim.modelojpa.model.entities;

import jakarta.persistence.*;
import lombok.*;
import org.jeslorlim.modelojpa.model.enbedded.Periodo;

import java.util.Set;
import java.util.UUID;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String nombre;

    // Embedded
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "fechaInicio", column = @Column(name = "fecha_comienzo")),
            @AttributeOverride(name = "fechaFin", column = @Column(name = "fecha_fin"))
    })
    private Periodo periodo;

    // OneToMany
    @OneToMany
    @JoinColumn(
            foreignKey = @ForeignKey(name = "FK_proyecto_empleados_proyecto_empleados")
    )
    private Set<ProyectoEmpleado> proyectoEmpleado;
}
