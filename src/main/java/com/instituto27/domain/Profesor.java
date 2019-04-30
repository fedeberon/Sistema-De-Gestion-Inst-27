package com.instituto27.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.function.Function;

/**
 * Created by ISFDyT Nº 27 on 6/11/2018.
 */

@Entity
@DiscriminatorValue("PROFESOR")
public class Profesor extends Usuario{

    private String nombre;

    private String apellido;

    private String DNI;

    @Column(name = "PRO_DIRECCION")
    private String direccion;

    @Column(name = "PRO_NUMERO")
    private String numero;

    @Column(name = "PRO_CELULAR")
    private String celular;

    @Column(name = "PRO_FIJO")
    private String fijo;

    @Column(name = "PRO_CUIL")
    private String cuil;

    @Column(name = "PRO_NACIMIENTO")
    private LocalDate nacimiento;

    @Column(name = "NOMBRE")
    public String getNombre() { return nombre;}

    public void setNombre(String nombre) {this.nombre = nombre;}

    @Column(name = "APELLIDO")
    public String getApellido() {return apellido;}

    public void setApellido(String apellido) {this.apellido = apellido;}

    @Column(name = "DNI")
    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getDireccion() {return direccion;}

    public void setDireccion(String direccion) {this.direccion = direccion;}

    public String getNumero() {return numero;}

    public void setNumero(String numero) {this.numero = numero;}

    public String getCelular() {return celular;}

    public void setCelular(String celular) {this.celular = celular;}

    public String getFijo() {return fijo;}

    public void setFijo(String fijo) { this.fijo = fijo; }

    public String getCuil() {return cuil; }

    public void setCuil(String cuil) { this.cuil = cuil; }

    public LocalDate getNacimiento() { return nacimiento; }

    public void setNacimiento(LocalDate nacimiento) {this.nacimiento = nacimiento;}


    @Override
    public String toString() {
        return nombre +" "+ apellido ;
    }

    @Override
    public <T> T evaluar(Function<Usuario, ? extends T> usuario, Function<Profesor, ? extends T> profesor, Function<Alumno, ? extends T> alumno, Function<Administrativo, ? extends T> administrativo) {
        return profesor.apply(this);
    }
}
