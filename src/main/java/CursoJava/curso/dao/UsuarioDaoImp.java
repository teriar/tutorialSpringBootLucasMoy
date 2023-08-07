package CursoJava.curso.dao;

import CursoJava.curso.models.Usuario;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContexts;
import java.util.List;

@Repository
@Transactional
public class UsuarioDaoImp implements  UsuarioDao{

@PersistenceContext
     EntityManager entityManeger;

    @Override
    public List<Usuario> getUsuarios()
    {
        String query = "FROM Usuario";
      return  entityManeger.createQuery(query).getResultList();

    }

    @Override
    public void eliminar(Long id) {
        Usuario usuario = entityManeger.find(Usuario.class,id);
        entityManeger.remove(usuario);
    }

    @Override
    public void regitrar(Usuario usuario) {
        entityManeger.merge(usuario);
    }

    @Override
    public boolean verificarCredenciales(Usuario usuario){
        System.out.print("dsa");
        String query=" FROM Usuario WHERE email = :email ";
        List<Usuario> lista = entityManeger.createQuery(query)
                .setParameter(  "email", usuario.getEmail())
                .getResultList();

        if(lista.isEmpty()){
            return false;
        }

        String passworHashed = lista.get(0).getPassword();

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        return  argon2.verify(passworHashed,usuario.getPassword());


    }
}
