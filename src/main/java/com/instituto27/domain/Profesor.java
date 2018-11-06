package com.instituto27.domain;

import javax.persistence.*;

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




}
