package com.instituto27.domain;

import javafx.collections.FXCollections;
import javafx.fxml.Initializable;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.persistence.*;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

/**
 * Created by ISFDyT Nº 27 on 26/06/2018.
 */

@Entity
@Table(name = "alumnos")
public class Alumno {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="ALU_ID")
    private Integer id;

    @Column(name = "ALU_NOMBRE")
    private String nombre;

    @Column(name = "ALU_APELLIDO")
    private String apellido;

    @Column(name = "ALU_DNI")
    private String DNI;

    @Column(name = "ALU_FECHA_DE_NACIMIENTO")
    private LocalDate fechaNacimiento;

    @Column(name = "ALU_CELULAR")
    private String celular;

    @Column(name = "ALU_DIRECCION")
    private String direccion;

    @Column(name = "ALU_EMAIL")
    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

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
}