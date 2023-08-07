package CursoJava.curso.dao;

import CursoJava.curso.models.Usuario;

import java.util.List;

public interface UsuarioDao {

    List<Usuario> getUsuarios();

    void eliminar(Long id);

    void regitrar(Usuario usuario);

    boolean verificarCredenciales(Usuario usuario);


}
