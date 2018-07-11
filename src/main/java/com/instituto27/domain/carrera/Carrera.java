package com.instituto27.domain.carrera;

import javax.persistence.*;

/**
 * Created by ISFDyT Nº 27 on 31/05/2018.
 */
@Entity
@Table (name= "carreras")
public class Carrera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="CAR_ID")
    private Integer id;

    @Column(name = "CAR_NOMBRE")
    private String nombre;

    @Column(name = "CAR_TURNO")
    private String turno;




    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

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
}
