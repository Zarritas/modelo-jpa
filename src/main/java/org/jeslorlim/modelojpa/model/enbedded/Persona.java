package org.jeslorlim.modelojpa.model.enbedded;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.MappedSuperclass;
import lombok.*;
import org.jeslorlim.modelojpa.enums.Genero;

import java.time.LocalDate;
@Embeddable
@MappedSuperclass
@Data @AllArgsConstructor @NoArgsConstructor
public class Persona{
    @Column(unique = true)
    private String nombre;
    @Column(nullable = false)
    private String apellidos;
    @Column(nullable = false)
    private LocalDate fechaNacimiento;
    @Column(nullable = false)
    private Genero genero;
}
