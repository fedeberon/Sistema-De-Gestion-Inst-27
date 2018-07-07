package com.instituto27.service.materia;

import com.instituto27.dao.materia.MateriaRepository;
import com.instituto27.domain.Materia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 29032017 on 05/07/2018.
 */
@Service
public class MateriaService {

    @Autowired
    private MateriaRepository dao;

    public Materia save(Materia materia) {
        return dao.save(materia);
    }
}
