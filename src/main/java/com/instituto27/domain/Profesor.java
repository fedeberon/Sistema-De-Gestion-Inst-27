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
    private Integer numero;

    @Column(name = "PRO_CELULAR")
    private Integer celular;

    @Column(name = "PRO_FIJO")
    private Integer fijo;

    @Column(name = "PRO_CUIL")
    private Integer cuil;

    @Column(name = "PRO_NACIMIENTO")
    private LocalDate nacimiento;

    public Integer getId() {return id;}

    public void setId(Integer id) {this.id = id;}

    public String getNombre() { return nombre;}

    public void setNombre(String nombre) {this.nombre = nombre;}

    public String getApellido() {return apellido;}

    public void setApellido(String apellido) {this.apellido = apellido;}

    public String getDireccion() {return direccion;}

    public void setDireccion(String direccion) {this.direccion = direccion;}

    public Integer getNumero() {return numero;}

    public void setNumero(Integer numero) {this.numero = numero;}

    public Integer getCelular() {return celular;}

    public void setCelular(Integer celular) {this.celular = celular;}

    public Integer getFijo() {return fijo;}

    public void setFijo(Integer fijo) { this.fijo = fijo; }

    public Integer getCuil() {return cuil; }

    public void setCuil(Integer cuil) { this.cuil = cuil; }

    public LocalDate getNacimiento() { return nacimiento; }

    public void setNacimiento(LocalDate nacimiento) {this.nacimiento = nacimiento;}
}
