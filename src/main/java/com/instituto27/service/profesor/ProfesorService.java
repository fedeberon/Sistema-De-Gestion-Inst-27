package com.instituto27.service.profesor;

import com.instituto27.dao.profesor.ProfesorRepository;
import com.instituto27.domain.Profesor;;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Created by Alan on 5/6/2018.
 */

@Service
public class ProfesorService {

    @Autowired
    private ProfesorRepository dao;

    public Profesor save(Profesor profesor) {
        return dao.save(profesor);
    }

    public Profesor update(Profesor profesor) {
        return dao.update(profesor);
    }

    public Profesor delete(Profesor id){

        return dao.delete(id);

    }

    public List<Profesor> findAll(){
        return dao.findAll();
    }

}

