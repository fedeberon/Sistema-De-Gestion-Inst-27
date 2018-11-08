package com.instituto27.service.inscripcion;

import com.instituto27.dao.inscripcion.InscripcionRepository;
import com.instituto27.domain.Inscripcion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by braian albo on 2/11/2018.
 */

@Service
public class InscripcionService {

    @Autowired
    private InscripcionRepository dao;

    public Inscripcion save(Inscripcion inscripcion){
        return dao.save(inscripcion);
    }


}
