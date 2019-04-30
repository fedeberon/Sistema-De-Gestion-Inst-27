package com.instituto27.domain;

import com.instituto27.domain.Usuario;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.function.Function;

/**
 * Created by ISFDyT Nº 27 on 23/04/2019.
 */

@Entity
@DiscriminatorValue("ADMINISTRATIVO")
public class Administrativo extends Usuario{

    private String nombre;

    private String apellido;

    private String DNI;

    @Column (name = "NOMBRE")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Column (name = "APELLIDO")
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Column (name = "DNI")
    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    @Override
    public <T> T evaluar(Function<Usuario, ? extends T> usuario, Function<Profesor, ? extends T> profesor, Function<Alumno, ? extends T> alumno, Function<Administrativo, ? extends T> administrativo) {
        return administrativo.apply(this);
    }
}
