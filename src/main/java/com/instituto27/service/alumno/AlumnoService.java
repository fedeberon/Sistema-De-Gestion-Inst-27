package com.instituto27.service.alumno;

import com.instituto27.dao.alumno.AlumnoRepository;
import com.instituto27.domain.Alumno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ISFDyT Nº 27 on 26/06/2018.
 */

@Service
public class AlumnoService {

    @Autowired
    private AlumnoRepository dao;

    public Alumno save(Alumno alumno) {
        return dao.save(alumno);
    }

    public List<Alumno> findAll(){
        return dao.findAll();
    }

    public Alumno getByDni(String dni){
        return dao.getByDni(dni);
    }

    public  Alumno delete(Alumno id){
        return dao.delete(id);
    }

}
