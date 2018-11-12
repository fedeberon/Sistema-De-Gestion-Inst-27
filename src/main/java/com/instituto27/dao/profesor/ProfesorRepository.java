package com.instituto27.dao.profesor;

import com.instituto27.domain.Profesor;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProfesorRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public Profesor save(Profesor profesor){
        Session sesion = sessionFactory.openSession();
        sesion.save(profesor);

        return profesor;
    }

    public Profesor update(Profesor id){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(id);
        session.getTransaction().commit();
        session.close();
        return id;
    }

    public Profesor delete(Profesor id){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(id);
        session.getTransaction().commit();
        session.close();
        return id;
    }

    public List<Profesor> findAll() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Profesor");
        return query.list();
    }
}