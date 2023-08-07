package CursoJava.curso.controllers;

import CursoJava.curso.dao.UsuarioDao;
import CursoJava.curso.models.Usuario;
import CursoJava.curso.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
     private UsuarioDao usuarioDao;

    @Autowired
    private JWTUtil jwTUtil;

    @RequestMapping(value="api/login", method = RequestMethod.POST)
    public String login(@RequestBody Usuario usuario){


        System.out.print(usuario);

        Usuario usuarioLogueado = usuarioDao.obtenerUsuarioPorCredenciales(usuario);
        if(usuarioLogueado !=null) {
          String tokenJwt = jwTUtil.create(String.valueOf(usuarioLogueado.getId()), usuarioLogueado.getEmail());

            return tokenJwt;
        }
      return "FAIL";

    }

}
