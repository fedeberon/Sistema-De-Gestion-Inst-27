package com.instituto27.dao.alumno;

import com.instituto27.domain.Alumno;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by ISFDyT Nº 27 on 11/05/2018.
 */

@Repository
public class AlumnoRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public Alumno save(Alumno alumno) {
        Session session = sessionFactory.openSession();
        session.save(alumno);

        return alumno;
    }

//    public Alumno save(Alumno alumno) {
//
//        Session session = sessionFactory.openSession();
//        session.save(alumno);
//
//    }
}
