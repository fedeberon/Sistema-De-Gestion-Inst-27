package dao.usuario;

/**
 * Created by ISFDyT Nº 27 on 31/05/2018.
 */
public class UsuarioRepository {



    public boolean validarUsuarioYPassword(String username, String password){

        if(username.equalsIgnoreCase("fede") && password.equals("fede")){
            return true;
        }

        else return false;

    }


}
