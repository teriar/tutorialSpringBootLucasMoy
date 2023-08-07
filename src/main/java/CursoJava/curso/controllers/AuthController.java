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
    private JWTUtil JWTUtil;

    @RequestMapping(value="api/login", method = RequestMethod.POST)
    public String login(@RequestBody Usuario usuario){


        System.out.print(usuario);

        if(usuarioDao.verificarCredenciales(usuario)){

          return "OK";
      }
      return "FAIL";

    }

}
