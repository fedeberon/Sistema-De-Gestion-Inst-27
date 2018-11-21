package com.instituto27.service.nota;

import com.instituto27.dao.nota.NotaRepository;
import com.instituto27.domain.Nota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotaService {

    @Autowired
    private NotaRepository dao;

    public Nota save(Nota nota) {
        return dao.save(nota);
    }

    public List<Nota> findAll() {
        return dao.findAll();
    }

}