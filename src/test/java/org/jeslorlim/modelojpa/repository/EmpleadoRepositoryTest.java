package org.jeslorlim.modelojpa.repository;

import org.jeslorlim.modelojpa.enums.Genero;
import org.jeslorlim.modelojpa.model.entities.Empleado;
import org.jeslorlim.modelojpa.repositories.EmpleadoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class EmpleadoRepositoryTest {
    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Test
    public void al_crear_un_empleado_se_almacena_correctamente() {
        Empleado e = new Empleado();
        e.setNombre("Jesús");
        e.setApellidos("Lorca");
        e.setFechaNacimiento(LocalDate.now());
        e.setGenero(Genero.Masculino);
        this.empleadoRepository.save(e);
    }

    @Test
    public void al_borrar_un_empleado_se_borra_correctamente() {
        Empleado e = new Empleado();
        e.setNombre("Jesús");
        e.setApellidos("Lorca");
        e.setFechaNacimiento(LocalDate.now());
        e.setGenero(Genero.Masculino);
        this.empleadoRepository.save(e);
        this.empleadoRepository.delete(e);
    }
    @Test
    public void agregar_jefe_a_empleado() {
        Empleado e = new Empleado();
        e.setNombre("Juan");
        e.setApellidos("Maria");
        e.setFechaNacimiento(LocalDate.now());
        e.setGenero(Genero.Masculino);
        this.empleadoRepository.save(e);
        Empleado jefe = new Empleado();
        jefe.setNombre("Jesús");
        jefe.setApellidos("Lorca");
        jefe.setFechaNacimiento(LocalDate.now());
        jefe.setGenero(Genero.Masculino);
        jefe.setJefe(e);
        this.empleadoRepository.save(jefe);
        System.out.println(empleadoRepository.findIdByNombre("Jesús"));
    }
}
