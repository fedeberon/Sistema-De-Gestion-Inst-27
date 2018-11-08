package com.instituto27.dao.inscripcion;

import com.instituto27.domain.Inscripcion;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by braian albo on 2/11/2018.
 */
@Repository
public class InscripcionRepository {

    @Autowired
    private SessionFactory sessionFactory;


    public Inscripcion save(Inscripcion inscripcion) {
        Session session = sessionFactory.openSession();
        session.save(inscripcion);

        return inscripcion;
    }
}
