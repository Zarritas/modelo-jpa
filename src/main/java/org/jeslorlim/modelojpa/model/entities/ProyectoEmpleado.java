package org.jeslorlim.modelojpa.model.entities;

import jakarta.persistence.*;
import lombok.*;
import org.jeslorlim.modelojpa.model.enbedded.Periodo;

import java.util.UUID;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class ProyectoEmpleado {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String rol;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "fechaInicio", column = @Column(name = "fecha_comienzo")),
            @AttributeOverride(name = "fechaFin", column = @Column(name = "fecha_fin"))
    })
    private Periodo periodo;

    // ManyToOne
    @ManyToOne
    @JoinColumn(
            name = "id_proyecto",
            foreignKey = @ForeignKey(name = "FK_proyecto_empleado_proyecto_proyecto")
    )
    private Proyecto proyecto;
    @ManyToOne
    @JoinColumn(
            name = "id_empleado",
            foreignKey = @ForeignKey(name = "FK_proyecto_empleado_empleado_empleado")
    )
    private Empleado empleado;
}
