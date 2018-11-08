package com.instituto27.dao.profesor;

import com.instituto27.domain.Profesor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProfesorRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public Profesor save(Profesor profesor){
        Session sesion = sessionFactory.openSession();
        sesion.save(profesor);

        return profesor;
    }

    public List<Profesor>


}
