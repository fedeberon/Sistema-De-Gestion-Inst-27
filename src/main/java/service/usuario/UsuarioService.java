package service.usuario;

import dao.usuario.UsuarioRepository;
import domain.Usuario;

public class UsuarioService {

    private UsuarioRepository dao = new UsuarioRepository();

    public boolean validarUsuarioYPassword(String username, String password){
        return dao.validarUsuarioYPassword(username, password);
    }

    public Usuario get(String username){
        return dao.get(username);
    }


}
