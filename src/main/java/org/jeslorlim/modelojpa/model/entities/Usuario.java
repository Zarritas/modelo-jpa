package org.jeslorlim.modelojpa.model.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String nombre;
    private String clave;
    private LocalDate fechaUltimaConexion;

    // Transient
    @Transient
    private String confirmClave;

    // mappedBy
//    @OneToOne(mappedBy = "usuario")
//    private Empleado empleado;
}