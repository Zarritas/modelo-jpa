package org.jeslorlim.modelojpa.model.enbedded;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Embeddable
@Data @AllArgsConstructor @NoArgsConstructor
public class ProyectoEmpleadoKey implements Serializable {

    private UUID idProyecto;
    private UUID idEmpleado;

}
