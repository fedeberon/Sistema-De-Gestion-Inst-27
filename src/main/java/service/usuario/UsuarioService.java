package service.usuario;

import dao.usuario.UsuarioRepository;
import domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
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
