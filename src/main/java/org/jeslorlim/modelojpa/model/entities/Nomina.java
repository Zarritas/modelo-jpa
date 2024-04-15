package org.jeslorlim.modelojpa.model.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Nomina {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String mes;
    private int anio;

    @OneToMany
    @JoinColumn(
            foreignKey = @ForeignKey(name = "FK_nomina_lineas_de_nomina_lineas_de_nomina")
    )
    private List<LineaDeNomina> lineasDeNomina;

    private double liquido;

    public void setLiquido() {
        lineasDeNomina.forEach(ln -> liquido += ln.getImporte());
    }
}
