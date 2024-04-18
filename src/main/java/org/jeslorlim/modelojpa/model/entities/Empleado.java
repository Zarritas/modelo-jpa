package org.jeslorlim.modelojpa.model.entities;

import jakarta.persistence.*;
import lombok.*;
import org.jeslorlim.modelojpa.model.enbedded.*;

import java.time.LocalDate;
import java.util.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = "id_usuario", name = "UQ_empleado_id_usuario"),
        @UniqueConstraint(columnNames = "id_informacion_economica", name = "UQ_empleado_id_informacion_economica")
})
@AllArgsConstructor @NoArgsConstructor @Data
public class Empleado extends Persona{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private LocalDate fechaEliminacion;
    private boolean activo;

    // Embedded
    @Embedded
    private Direccion direccion;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "fechaInicio", column = @Column(name = "fecha_contratacion")),
            @AttributeOverride(name = "fechaFin", column = @Column(name = "fecha_cese")),
            @AttributeOverride(name = "motivo", column = @Column(name = "motivo"))
    })
    private PeriodoContratacion periodoContratacion;

    // OneToOne
    @OneToOne
    @JoinColumn(
            name = "id_informacion_economica",
            foreignKey = @ForeignKey(name = "FK_empleado_informacion_economica_informacion_economica")
    )
    private InformacionEconomica informacionEconomica;
    @OneToOne
    @JoinColumn(
            name = "id_usuario",
            foreignKey = @ForeignKey(name = "FK_empleado_usuario_usuario")
    )
    private Usuario usuario;

//    @OneToMany(fetch = FetchType.LAZY)
//    @JoinColumn(
//            foreignKey = @ForeignKey(name = "FK_empleado_nomina_nominas")
//    )
//    private Set<Nomina> nominas;

    // ManyToOne
    @ManyToOne
    @JoinColumn(
            name = "id_jefe",
            foreignKey = @ForeignKey(name = "FK_empleado_empleado_jefe")
    )
    private Empleado jefe;
    @ManyToOne
    @JoinColumn(
            name = "id_departamento",
            foreignKey = @ForeignKey(name = "FK_empleado_departamento_id_departamento")
    )
    private Departamento idDepartamento;

    // Mapped by
//    @ManyToMany(mappedBy = "empleados")
//    private Set<GrupoDeDesarrollo> grupos;
//    @OneToOne(mappedBy = "mentor")
//    private Becario becario;
//    @OneToOne(mappedBy = "jefe")
//    private Departamento idDepartamentoJefe;
//    @OneToMany(mappedBy = "jefe")
//    private Set<Empleado> subordinados;
}