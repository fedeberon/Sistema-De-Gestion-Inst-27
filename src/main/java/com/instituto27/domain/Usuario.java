package com.instituto27.domain;

import javax.persistence.*;
import java.util.function.Function;

/**
 * Created by ISFDyT Nº 27 on 07/06/2018.
 */

@Entity
@Table(name = "usuarios")
@DiscriminatorColumn
public class Usuario extends Persona {

    @Id
    @Column(name = "USERNAME")
    private String username;

    @Column(name = "PASSWORD")
    private String password;

    private String nombre;

    private String apellido;

    private String DNI;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

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

    @Column(name = "DNI")
    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public <T> T evaluar(Function<Usuario, ? extends T> usuario, Function<Profesor, ? extends T> profesor, Function<Alumno, ? extends T> alumno, Function<Administrativo, ? extends T> administrativo) {
        return usuario.apply(this);
    }
}
