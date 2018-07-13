package com.instituto27.service.carreras;

import com.instituto27.dao.carrera.CarreraRepository;
import com.instituto27.domain.carrera.Carrera;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by ISFDyT Nº 27 on 31/05/2018.
 */
@Service
public class CarreraService {

    @Autowired
    public CarreraRepository dao;

    public Carrera save(Carrera carrera) {
        return dao.save(carrera);
    }

    public List<Carrera> findAll(){
        return dao.findAll();
    }
}

