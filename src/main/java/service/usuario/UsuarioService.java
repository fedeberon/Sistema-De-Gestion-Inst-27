package service.usuario;

import dao.usuario.UsuarioRepository;

public class UsuarioService {

    private UsuarioRepository dao = new UsuarioRepository();

    public boolean validarUsuarioYPassword(String username, String password){
        return dao.validarUsuarioYPassword(username, password);
    }


}
