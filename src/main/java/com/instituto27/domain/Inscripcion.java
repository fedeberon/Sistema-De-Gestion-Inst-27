package com.instituto27.domain;

import com.instituto27.domain.carrera.Carrera;

import javax.persistence.*;

/**
 * Created by braian albo on 2/11/2018.
 */

@Entity
@Table(name = "inscripciones")
public class Inscripcion {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="INS_ID")
    private Long id;

    @OneToOne
    @JoinColumn(name ="INS_ALU_ID")
    private Alumno alumno;

    @OneToOne
    @JoinColumn(name ="INS_CAR_ID")
    private Carrera carrera;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }
}
