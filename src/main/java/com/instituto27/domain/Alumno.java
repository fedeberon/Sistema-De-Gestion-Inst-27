package com.instituto27.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.function.Function;

/**
 * Created by ISFDyT Nº 27 on 26/06/2018.
 */

@Entity
@DiscriminatorValue("ALUMNO")
public class Alumno extends Usuario {

    private String nombre;

    private String apellido;

    private String DNI;

    @Column(name = "ALU_FECHA_DE_NACIMIENTO")
    private LocalDate fechaNacimiento;

    @Column(name = "ALU_CELULAR")
    private String celular;

    @Column(name = "ALU_DIRECCION")
    private String direccion;

    @Column(name = "ALU_EMAIL")
    private String email;

    @Column(name = "NOMBRE")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Column(name = "APELLIDO")
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Column(name = "DNI")
    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return nombre + " " + apellido;
    }

    @Override
    public <T> T evaluar(Function<Usuario, ? extends T> usuario, Function<Profesor, ? extends T> profesor, Function<Alumno, ? extends T> alumno, Function<Administrativo, ? extends T> administrativo) {
        return alumno.apply(this);
    }
}