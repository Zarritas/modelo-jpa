package org.jeslorlim.modelojpa.model.entities;

import jakarta.persistence.*;
import lombok.*;
import org.jeslorlim.modelojpa.model.enbedded.Periodo;
import org.jeslorlim.modelojpa.model.enbedded.ProyectoEmpleadoKey;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class ProyectoEmpleado {
    private String rol;

    // Embedded
    @EmbeddedId
    private ProyectoEmpleadoKey id;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "fechaInicio", column = @Column(name = "fecha_comienzo")),
            @AttributeOverride(name = "fechaFin", column = @Column(name = "fecha_fin"))
    })
    private Periodo periodo;

    // ManyToOne
    @ManyToOne
    @MapsId("idProyecto")
    @JoinColumn(
            name = "proyecto",
            foreignKey = @ForeignKey(name = "FK_proyecto_empleado_proyecto_proyecto")
    )
    private Proyecto proyecto;
    @ManyToOne
    @MapsId("idEmpleado")
    @JoinColumn(
            name = "id_empleado",
            foreignKey = @ForeignKey(name = "FK_proyecto_empleado_empleado_empleado")
    )
    private Empleado empleado;
}
