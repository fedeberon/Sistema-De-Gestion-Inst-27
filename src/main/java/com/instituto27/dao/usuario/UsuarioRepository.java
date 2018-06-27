package com.instituto27.dao.usuario;

import com.instituto27.domain.Usuario;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ISFDyT Nº 27 on 31/05/2018.
 */
@Repository
public class UsuarioRepository{

    @Autowired
    private SessionFactory sessionFactory;



    public boolean validarUsuarioYPassword(String username, String password){
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Usuario where username =:username and password =:password");
        query.setParameter("username", username);
        query.setParameter("password", password);

        if(query.list().size() > 0l){
            return true;
        }
        else return false;
    }

    public Usuario get(String username) {
        Session session = sessionFactory.openSession();

        return session.get(Usuario.class, username);
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
