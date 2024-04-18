package org.jeslorlim.modelojpa.model.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;
import java.util.UUID;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Nomina {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String mes;
    private int anio;

    @ManyToOne
    @JoinColumn(
            name="id_empleado",
            foreignKey = @ForeignKey(name = "FK_nomina_empleado_empleado")
    )
    private Empleado empleado;

    private double liquido;

    public void setLiquido(Set<LineaDeNomina> lineasDeNomina) {
        lineasDeNomina.forEach(ln -> liquido += ln.getImporte());
    }
}
