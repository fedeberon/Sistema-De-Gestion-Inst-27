package com.instituto27.domain;

import com.instituto27.domain.carrera.Carrera;

import javax.lang.model.element.Name;
import javax.persistence.*;

@Entity
@Table(name = "MATERIAS")
public class Materia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MAT_ID")
    private Long id;

    @Column(name = "MAT_NOMBRE")
    private String nombre;

    @Column(name = "MAT_PROFESOR")
    private String profesor;

    @ManyToOne
    @JoinColumn(name = "MAT_CAR_ID")
    private Carrera carrera;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    @Override
    public String toString() {
        return nombre ;
    }

}
