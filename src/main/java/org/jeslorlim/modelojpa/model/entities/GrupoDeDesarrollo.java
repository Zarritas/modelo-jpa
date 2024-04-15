package org.jeslorlim.modelojpa.model.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;
import java.util.UUID;

@Entity
@AllArgsConstructor @NoArgsConstructor @Data
public class GrupoDeDesarrollo {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String nombre;

    // mappedBy
    @ManyToMany
    @JoinTable(
            name = "grupos_desarrollo_empleados",
            joinColumns = @JoinColumn(
                    name = "id_grupos_desarrollo",
                    foreignKey = @ForeignKey(name = "FK_grupos_desarrollo_empleados_grupos_desarrollo")
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "id_empleados",
                    foreignKey = @ForeignKey(name = "FK_grupos_desarrollo_empleados_empleados")
            )
    )
    private Set<Empleado> empleados;
}