package org.jeslorlim.modelojpa.model.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(
    name = "uk_departamento_jefe",
    columnNames = "id_jefe"
))
@AllArgsConstructor @NoArgsConstructor @Data
public class Departamento {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String nombre;
    private String codigo;
    private BigDecimal presupuesto;
    private String localidad;

    // OneToOne
    @OneToOne
    @JoinColumn(
            name = "id_jefe",
            foreignKey = @ForeignKey(name = "FK_departamento_empleado_jefe")
    )
    private Empleado jefe;
}
