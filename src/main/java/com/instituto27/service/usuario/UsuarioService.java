package com.instituto27.service.usuario;

import com.instituto27.dao.usuario.UsuarioRepository;
import com.instituto27.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class UsuarioService {

    @Autowired
    private UsuarioRepository dao;

    public boolean validarUsuarioYPassword(String username, String password){
        return dao.validarUsuarioYPassword(username, password);
    }

    public Usuario get(String username){
        return dao.get(username);
    }


}
