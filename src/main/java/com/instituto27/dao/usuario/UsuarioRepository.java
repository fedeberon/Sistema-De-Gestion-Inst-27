package dao.usuario;

import domain.Usuario;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by ISFDyT Nº 27 on 31/05/2018.
 */
public class UsuarioRepository{

    @Autowired
    SessionFactory sessionFactory;



    public boolean validarUsuarioYPassword(String username, String password){
        if(username.equalsIgnoreCase("fede") && password.equals("fede")){
            return true;
        }
        else return false;
    }

    public Usuario get(String username) {
        Session session = sessionFactory.openSession();

        return (Usuario) session.get(Usuario.class, username);
    }

    public List<Usuario> findAll() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Usuario");
        List list = query.list();

        return list;
    }

    public Usuario save() {
        return new Usuario();
    }


}
