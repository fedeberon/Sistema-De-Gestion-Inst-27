package com.instituto27.domain;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by ISFDyT Nº 27 on 6/11/2018.
 */

@Entity
@Table(name = "profesores")
public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="PRO_ID")
    private Integer id;

    @Column(name = "PRO_NOMBRE")
    private String nombre;

    @Column(name = "PRO_APELLIDO")
    private String apellido;

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

    public Integer getId(){return id;}

    public void setId(Integer id){this.id = id;}

    public String getNombre() { return nombre;}

    public void setNombre(String nombre) {this.nombre = nombre;}

    public String getApellido() {return apellido;}

    public void setApellido(String apellido) {this.apellido = apellido;}

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

}
