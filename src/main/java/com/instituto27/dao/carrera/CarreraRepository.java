package com.instituto27.dao.carrera;

import com.instituto27.domain.carrera.Carrera;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ISFDyT Nº 27 on 04/07/2018.
 */
@Repository
public class CarreraRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public Carrera save(Carrera carrera) {
        Session session = sessionFactory.openSession();
        session.save(carrera);

        return carrera;
    }

    public List<Carrera> findAll() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Carrera");

        return query.list();
    }
}
