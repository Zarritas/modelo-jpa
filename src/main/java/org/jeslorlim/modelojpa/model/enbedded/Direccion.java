package org.jeslorlim.modelojpa.model.enbedded;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigInteger;

@Embeddable
@Data @NoArgsConstructor @AllArgsConstructor
public class Direccion {

    private String tipoVia;
    private String via;
    private int numero;
    private String piso;
    private String puerta;
    private String localidad;
    private BigInteger cp;
    private String region;
    private String pais;
}
