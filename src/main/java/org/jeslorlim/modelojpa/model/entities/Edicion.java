package org.jeslorlim.modelojpa.model.entities;

import jakarta.persistence.*;
import lombok.*;
import org.jeslorlim.modelojpa.model.enbedded.*;

import java.util.Set;
import java.util.UUID;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Edicion {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private int duracion;

    // Embedded
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "fechaInicio", column = @Column(name = "fecha_comienzo")),
            @AttributeOverride(name = "fechaFin", column = @Column(name = "fecha_fin"))
    })
    private Periodo periodo;

    // ManyToOne
    @ManyToOne
    @JoinColumn(
            foreignKey = @ForeignKey(name = "FK_edicion_empleado_poniente")
    )
    private Empleado ponente;
    @ManyToOne
    @JoinColumn(
            foreignKey = @ForeignKey(name = "FK_edicion_curso_formacion")
    )
    private CursoDeFormacion formacion;

    // ManyToMany
    @ManyToMany(mappedBy = "edicionEstudiante")
    private Set<Empleado> estudiantes;

}
