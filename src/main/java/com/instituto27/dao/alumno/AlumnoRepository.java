package com.instituto27.dao.alumno;

import com.instituto27.domain.Alumno;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.util.List;
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

    public List<Alumno> findAll() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Alumno");

        return query.list();
    }


    public Alumno getByDni(String dni) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Alumno where DNI = :dni");
        query.setParameter("dni", dni);

        return (Alumno) query.uniqueResult();
    }

    public Alumno delete(Alumno id){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(id);
        session.getTransaction().commit();
        session.close();
        return id;
    }

}
