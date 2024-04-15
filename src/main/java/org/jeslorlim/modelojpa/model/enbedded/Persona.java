package org.jeslorlim.modelojpa.model.enbedded;

import jakarta.persistence.Embeddable;
import lombok.*;
import org.jeslorlim.modelojpa.enums.Genero;

import java.time.LocalDate;
@Embeddable
@Data @AllArgsConstructor @NoArgsConstructor
public class Persona{
    private String nombre;
    private String apellidos;
    private LocalDate fechaNacimiento;
    private Genero genero;
}
