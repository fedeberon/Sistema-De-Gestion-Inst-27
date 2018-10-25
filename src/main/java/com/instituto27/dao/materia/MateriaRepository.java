package com.instituto27.dao.materia;

import com.instituto27.domain.Materia;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 29032017 on 05/07/2018.
 */
@Repository
public class MateriaRepository {


    @Autowired
    private SessionFactory sessionFactory;

    public Materia save(Materia materia) {
        Session session = sessionFactory.openSession();
        session.save(materia);

        return materia;
    }

    public List<Materia> findAll() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Materia");

        return query.list();
    }
}