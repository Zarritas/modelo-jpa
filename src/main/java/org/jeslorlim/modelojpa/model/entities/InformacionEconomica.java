package org.jeslorlim.modelojpa.model.entities;

import jakarta.persistence.*;
import lombok.*;
import org.jeslorlim.modelojpa.model.enbedded.TarjetaCredito;

import java.util.ArrayList;
import java.util.UUID;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class InformacionEconomica {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private Double salario;
    private Double comision;

    // Embedded
    @Embedded
    private TarjetaCredito tarjetaCredito;


//    @OneToOne(mappedBy = "informacionEconomica")
//    private Empleado empleado;
}
