package com.instituto27.domain;

import javax.persistence.*;

@Entity
@Table(name = "NOTAS")
public class Nota {

    @Id
    @Column
    private Long id;

    @Column
    private String nota;

    public void setNota(String nota) {
        this.nota = nota;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNota() {
        return nota;
    }
}
