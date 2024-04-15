package org.jeslorlim.modelojpa.model.enbedded;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
@Embeddable
@AllArgsConstructor @NoArgsConstructor @Data
public class Periodo {
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
}