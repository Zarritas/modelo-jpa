package org.jeslorlim.modelojpa.Data;

import org.jeslorlim.modelojpa.model.enbedded.*;
import org.jeslorlim.modelojpa.model.entities.*;
import org.jeslorlim.modelojpa.enums.Genero;
import org.jeslorlim.modelojpa.enums.Motivo;
import org.jeslorlim.modelojpa.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Component
public class AgregarDatos {
    @Autowired
    DepartamentoRepository departamentoRepositorio;
    @Autowired
    EmpleadoRepository empleadoRepositorio;
    @Autowired
    BecarioRepository becarioRepositorio;
    @Autowired
    NominaRepository nominaRepositorio;
    @Autowired
    LineaDeNominaRepository lineaDeNominaRepositorio;
    @Autowired
    ProyectoRepository proyectoRepositorio;
    @Autowired
    ProyectoEmpleadoRepository proyectoEmpleadoRepositorio;
    @Autowired
    InformacionEconomicaRepository informacionEconomicaRepositorio;
    @Autowired
    UsuarioRepository usuarioRepositorio;
    @Autowired
    CursoDeFormacionRepository cursoDeFormacionRepositorio;
    @Autowired
    EdicionRepository edicionRepositorio;
    @Autowired
    GrupoDeDesarrolloRepository grupoDeDesarrolloRepositorio;
    @Autowired
    EstudianteEdicionRepository estudianteEdicionRepository;

//    @Bean
//    public void eliminaDepartamentos (){
//        departamentoRepositorio.deleteAll();
//    }

    @Bean
    private void pueblaDepartamentos(){

        Direccion dire1 = new Direccion("Calle","Gonzalez",19,"1","b","Huelva", BigInteger.valueOf(21001),"Huelva","Espana");
        Direccion dire2 = new Direccion("Calle","frifri",36,"5","g","Madrid", BigInteger.valueOf(28038),"Madrid","Espana");
        Periodo per1 = new Periodo(LocalDate.of(2019,1,1),LocalDate.of(2020,1,1));
        Periodo per2 = new Periodo(LocalDate.of(2020,1,1),LocalDate.of(2021,1,1));
        PeriodoContratacion pc1 = new PeriodoContratacion(LocalDate.of(2019,1,1),LocalDate.of(2020,1,1), Motivo.Jubilacion);
        PeriodoContratacion pc2 = new PeriodoContratacion(LocalDate.of(2019,1,1));
        TarjetaCredito tc1 = new TarjetaCredito("1234567890123456", LocalDate.of(2025,1,1), 123);
        TarjetaCredito tc2 = new TarjetaCredito("1234567890123456", LocalDate.of(2025,1,1), 321);

        Becario b1 = new Becario();
        Becario b2 = new Becario();
        CursoDeFormacion cf1 = new CursoDeFormacion();
        CursoDeFormacion cf2 = new CursoDeFormacion();
        Departamento d1 = new Departamento();
        Departamento d2 = new Departamento();
        Edicion ed1 = new Edicion();
        Edicion ed2 = new Edicion();
        Empleado e1 = new Empleado();
        Empleado e2 = new Empleado();
        GrupoDeDesarrollo g1 = new GrupoDeDesarrollo();
        GrupoDeDesarrollo g2 = new GrupoDeDesarrollo();
        InformacionEconomica ie1 = new InformacionEconomica();
        InformacionEconomica ie2 = new InformacionEconomica();
        LineaDeNomina ln1 = new LineaDeNomina();
        LineaDeNomina ln2 = new LineaDeNomina();
        Nomina n1 = new Nomina();
        Nomina n2 = new Nomina();
        Proyecto pr1 = new Proyecto();
        Proyecto pr2 = new Proyecto();
        ProyectoEmpleado pe1 = new ProyectoEmpleado();
        ProyectoEmpleado pe2 = new ProyectoEmpleado();
        Usuario u1 = new Usuario();
        Usuario u2 = new Usuario();
        EstudianteEdicion ee = new EstudianteEdicion();
        EstudianteEdicion ee2 = new EstudianteEdicion();
        EstudianteEdicion ee3 = new EstudianteEdicion();

        ln1.setConcepto("Concepto 1");ln1.setImporte(-356);
        ln2.setConcepto("Concepto 2");ln2.setImporte(55524);
        nominaRepositorio.saveAll(List.of(n1,n2));

        cf1.setDuracion(1562);cf1.setNombre("Curso de formacion 1");
        cf2.setDuracion(1588);cf2.setNombre("Curso de formacion 2");
        cursoDeFormacionRepositorio.saveAll(List.of(cf1,cf2));

        d1.setNombre("Departamento 1");d1.setLocalidad("Localidad 1");d1.setCodigo("10");d1.setPresupuesto(BigDecimal.valueOf(1000));
        d2.setNombre("Departamento 2");d1.setLocalidad("Localidad 2");d1.setCodigo("20");d1.setPresupuesto(BigDecimal.valueOf(2000));
        departamentoRepositorio.saveAll(List.of(d1,d2));

        ed1.setDuracion(152);ed1.setFormacion(cf1);ed1.setPeriodo(per1);
        ed2.setDuracion(152);ed2.setFormacion(cf2);ed2.setPeriodo(per2);
        edicionRepositorio.saveAll(List.of(ed1,ed2));

        ie1.setSalario(152.3);ie1.setComision(155.36);ie1.setTarjetaCredito(tc1);
        ie2.setSalario(152.3);ie2.setComision(155.36);ie2.setTarjetaCredito(tc2);
        informacionEconomicaRepositorio.saveAll(List.of(ie1,ie2));



        e1.setNombre("Luis");e1.setApellidos("Perez");e1.setFechaNacimiento(LocalDate.of(1980,1,1));e1.setGenero(Genero.Masculino);e1.setDireccion(dire1);e1.setIdDepartamento(d1);e1.setPeriodoContratacion(pc1);e1.setInformacionEconomica(ie1);
        e2.setNombre("Manolo");e2.setApellidos("Perez");e2.setFechaNacimiento(LocalDate.of(1980,1,1));e2.setGenero(Genero.NoBinario);e2.setDireccion(dire2);e2.setIdDepartamento(d2);e2.setPeriodoContratacion(pc2);e2.setInformacionEconomica(ie2);
        empleadoRepositorio.saveAll(List.of(e1,e2));

        n1.setAnio(2019);n1.setMes("Noviembre");n1.setEmpleado(e1);
        n2.setAnio(2020);n2.setMes("Diciembre");n2.setEmpleado(e2);
        nominaRepositorio.saveAll(List.of(n1,n2));

        ln1.setConcepto("platano");ln1.setImporte(553);ln1.setNomina(n1);
        ln2.setConcepto("pomelo");ln2.setImporte(-18);ln2.setNomina(n2);
        lineaDeNominaRepositorio.saveAll(List.of(ln1,ln2));

        n1.setLiquido(lineaDeNominaRepositorio.findByNomina(n1));
        n2.setLiquido(lineaDeNominaRepositorio.findByNomina(n2));
        nominaRepositorio.saveAll(List.of(n1,n2));

        ee.setEmpleado(e1);ee.setNota(19);ee.setEdicion(ed1);
        ee2.setEmpleado(e1);ee.setNota(52);ee.setEdicion(ed2);
        ee3.setEmpleado(e2);ee.setNota(25);ee.setEdicion(ed1);
        estudianteEdicionRepository.saveAll(List.of(ee,ee2,ee3));

        b1.setNombre("Gonzalo");b1.setApellidos("Perez");b1.setFechaNacimiento(LocalDate.of(1980,1,1));b1.setGenero(Genero.Masculino);b1.setCentroEducativo("Centro educativo 1");b1.setDireccionPersonal(dire1);b1.setDireccionCentroEducativo(dire2);b1.setMentor(empleadoRepositorio.findByNombre(e2.getNombre()));
        b2.setNombre("Maria");b2.setApellidos("Perez");b2.setFechaNacimiento(LocalDate.of(1980,1,1));b2.setGenero(Genero.Femenino);b2.setCentroEducativo("Centro educativo 2");b2.setDireccionPersonal(dire2);b1.setDireccionCentroEducativo(dire1);b2.setMentor(empleadoRepositorio.findByNombre(e1.getNombre()));
        becarioRepositorio.saveAll(List.of(b1,b2));

        g1.setNombre("Grupo 1");
        g2.setNombre("Grupo 2");
        grupoDeDesarrolloRepositorio.saveAll(List.of(g1,g2));


        pr1.setNombre("Proyecto 1");pr1.setPeriodo(per1);
        pr2.setNombre("Proyecto 2");pr2.setPeriodo(per2);
        proyectoRepositorio.saveAll(List.of(pr1,pr2));

        pe1.setRol("Rol 1");pe1.setEmpleado(e1);pe1.setProyecto(pr1);
        pe2.setRol("Rol 2");pe1.setEmpleado(e2);pe1.setProyecto(pr2);
        proyectoEmpleadoRepositorio.saveAll(List.of(pe1,pe2));

        u1.setNombre("Usuario 1");u1.setClave("clave1");u1.setConfirmClave("clave1");
        u2.setNombre("Usuario 2");u2.setClave("clave2");u2.setConfirmClave("clave2");u2.setFechaUltimaConexion(LocalDate.now());
        usuarioRepositorio.saveAll(List.of(u1,u2));


    }
    @Bean
    private void listaEmpleados() {
        System.err.println("Listado de Empleados");
        List<Empleado> empleados = empleadoRepositorio.findAll();
        for(Empleado e : empleados){
            System.out.println(e);
        };
        System.err.println("Listado de Nominas");
        nominaRepositorio.findAll().forEach(System.out::println);
    }
}
