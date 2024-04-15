package org.jeslorlim.modelojpa.model.entities;

import jakarta.persistence.*;
import lombok.*;
import org.jeslorlim.modelojpa.model.enbedded.*;

import java.util.UUID;

@Entity
@Table(
        uniqueConstraints = @UniqueConstraint(
                columnNames = "id_mentor",
                name = "UQ_becario_mentor")
)
@AllArgsConstructor @NoArgsConstructor @Data
public class Becario{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idBecario;

    private String centroEducativo;

    // Embedded
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "nombre", column = @Column(nullable = false)),
            @AttributeOverride(name = "apellidos", column = @Column(nullable = false)),
            @AttributeOverride(name = "fechaNacimiento", column = @Column(nullable = false)),
            @AttributeOverride(name = "genero", column = @Column(nullable = false))
    })
    private Persona persona;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "tipoVia", column = @Column(name = "tipo_via_personal")),
            @AttributeOverride(name = "via", column = @Column(name = "via_personal")),
            @AttributeOverride(name = "numero", column = @Column(name = "numero_personal")),
            @AttributeOverride(name = "piso", column = @Column(name = "piso_personal")),
            @AttributeOverride(name = "puerta", column = @Column(name = "puerta_personal")),
            @AttributeOverride(name = "localidad", column = @Column(name = "localidad_personal")),
            @AttributeOverride(name = "cp", column = @Column(name = "cp_personal")),
            @AttributeOverride(name = "region", column = @Column(name = "region_personal")),
            @AttributeOverride(name = "pais", column = @Column(name = "pais_personal"))
    })
    private Direccion direccionPersonal;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "tipoVia", column = @Column(name = "tipo_via_centro_educativo")),
            @AttributeOverride(name = "via", column = @Column(name = "via_centro_educativo")),
            @AttributeOverride(name = "numero", column = @Column(name = "numero_centro_educativo")),
            @AttributeOverride(name = "piso", column = @Column(name = "piso_centro_educativo")),
            @AttributeOverride(name = "puerta", column = @Column(name = "puerta_centro_educativo")),
            @AttributeOverride(name = "localidad", column = @Column(name = "localidad_centro_educativo")),
            @AttributeOverride(name = "cp", column = @Column(name = "cp_centro_educativo")),
            @AttributeOverride(name = "region", column = @Column(name = "region_centro_educativo")),
            @AttributeOverride(name = "pais", column = @Column(name = "pais_centro_educativo"))
    })
    private Direccion direccionCentroEducativo;

    // OneToOne
    @OneToOne
    @JoinColumn(
            name = "id_mentor",
            nullable = false,
            foreignKey = @ForeignKey(name = "FK_becario_empleado_mentor")
    )
    private Empleado mentor;
}