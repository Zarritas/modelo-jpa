package org.jeslorlim.modelojpa.model.enbedded;

import jakarta.persistence.Embeddable;
import lombok.*;
import org.jeslorlim.modelojpa.enums.Motivo;

import java.time.LocalDate;

@Embeddable
@NoArgsConstructor @AllArgsConstructor @Data
public class PeriodoContratacion {

    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Motivo motivo;

    public PeriodoContratacion(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = null;
        this.motivo = null;
    }
}
