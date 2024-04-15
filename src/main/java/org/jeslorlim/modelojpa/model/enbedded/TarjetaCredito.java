package org.jeslorlim.modelojpa.model.enbedded;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Embeddable
@AllArgsConstructor @NoArgsConstructor @Data
public class TarjetaCredito {

    private String numero;
    private LocalDate fechaCaducidad;
    private int cvv;
}
