package org.jeslorlim.modelojpa.model.entities;

import jakarta.persistence.*;
import lombok.*;
import org.jeslorlim.modelojpa.model.enbedded.*;

import java.time.LocalDate;
import java.util.*;

@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = "id_usuario", name = "UQ_empleado_id_usuario"),
        @UniqueConstraint(columnNames = "id_informacion_economica", name = "UQ_empleado_id_informacion_economica")
})
@AllArgsConstructor @NoArgsConstructor @Data
public class Empleado{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private LocalDate fechaEliminacion;
    private boolean activo;

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

    @OneToMany
    @JoinColumn(
            foreignKey = @ForeignKey(name = "FK_empleado_nomina_nominas")
    )
    private List<Nomina> nominas;

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

    // ManyToMany
    @ManyToMany
    @JoinTable(
            name = "empleados_edicion",
            joinColumns = @JoinColumn(name = "id_empleado"),
            inverseJoinColumns = @JoinColumn(name = "id_edicion")
    )
    private Set<Edicion> edicionEstudiante = new HashSet<>();

    // Mapped by
//    @ManyToMany(mappedBy = "empleados")
//    private Set<GrupoDeDesarrollo> grupos;
//    @OneToOne(mappedBy = "mentor")
//    private Becario becario;
//    @OneToOne(mappedBy = "jefe")
//    private Departamento idDepartamentoJefe;
//    @OneToMany(mappedBy = "jefe")
//    private Set<Empleado> subordinados;

    // metodos geter y seter personalizados
    public void setEdicionEstudiante(Edicion edicion) {
        edicionEstudiante.add(edicion);
    }
}