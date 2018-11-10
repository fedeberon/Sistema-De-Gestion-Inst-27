package com.instituto27.dao.nota;

import com.instituto27.domain.Nota;
import com.instituto27.domain.carrera.Carrera;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NotaRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public Nota save(Nota nota) {
        Session session = sessionFactory.openSession();
        session.save(nota);

        return nota;
    }

    public List<Carrera> findAll() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Nota");

        return query.list();
    }
}