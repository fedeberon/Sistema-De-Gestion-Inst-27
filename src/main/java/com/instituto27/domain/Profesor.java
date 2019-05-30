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

    @Column(name = "PRO_EMAIL")
    private String email;

    @Column(name = "PRO_TITULO")
    private String titulo;

    @Column(name = "PRO_NRO_REGISTRO")
    private String nroregistro;

    @Column(name = "PRO_TUTULO_OTORGADO")
    private String titotorgado;

    @Column(name = "PRO_ANTIGUEDAD")
    private String antiguedad;

    @Column(name = "PRO_TOMA_POSECION")
    private LocalDate tomaposecion;




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

    public String getEmail() {return email;}

    public void setEmail(String email) { this.email = email; }

    public String getTitulo() {return titulo;}

    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getNroregistro() {return nroregistro;}

    public void setNroregistro(String nroregistro) { this.nroregistro = nroregistro; }

    public String getTitotorgado() {return titotorgado;}

    public void setTitotorgado(String titotorgado) { this.titotorgado = titotorgado; }

    public String getAntiguedad() {return antiguedad;}

    public void setAntiguedad(String antiguedad) { this.antiguedad = antiguedad; }

    public LocalDate getTomaposecion() { return tomaposecion; }

    public void setTomaposecion(LocalDate tomaposecion) {this.tomaposecion = tomaposecion;}


    @Override
    public String toString() {
        return nombre +" "+ apellido ;
    }
}
