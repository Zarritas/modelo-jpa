package org.jeslorlim.modelojpa.model.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;
import java.util.UUID;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class LineaDeNomina {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(
            name = "id_nomina",
            foreignKey = @ForeignKey(name = "FK_linea_de_nomina_nomina_nomina")
    )
    private Nomina nomina;

    private String concepto;
    private double importe;
}
