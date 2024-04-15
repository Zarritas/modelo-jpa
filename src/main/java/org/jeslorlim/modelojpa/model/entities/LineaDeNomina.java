package org.jeslorlim.modelojpa.model.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class LineaDeNomina {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String concepto;
    private double importe;
}
