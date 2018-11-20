package com.instituto27.domain;

import com.instituto27.domain.carrera.Carrera;

import javax.persistence.*;

@Entity
@Table(name = "notas")
public class Nota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NOTA_ID")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "NOTA_CAR_ID")
    private Carrera carrera;

    @ManyToOne
    @JoinColumn(name = "NOTA_MAT_ID")
    private Materia materia;

    @ManyToOne
    @JoinColumn(name = "NOTA_ALU_ID")
    private Alumno alumno;

    @Column(name = "NOTA_VALOR")
    private String nota;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }
}