package com.example.demo.controllers;

import com.example.demo.models.UsuarioModel;
import com.example.demo.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @GetMapping()
    public ArrayList<UsuarioModel> obtenerUsuarios(){
        return usuarioService.obtenerUsuarios();
    }

    @PostMapping()
    public UsuarioModel guardarUsuario (@RequestBody UsuarioModel usuario){
        return this.usuarioService.guardarUsuario(usuario);
    }
    /*para agregar un usuario se usa postman en modo POST, raw Y JSON:
    {
        "nombre" : "Pedro",
        "email" : "Pedro@gmail.com",
        "prioridad" : "2"
    }

    para reemplazar un usuario se hace de la misma forma excepto que se le especifica
    el id del usuario ya guardado, gracias al método save del repositorio:
        {
        "id": 1,
        "nombre": "Juanito",
        "email": "Juanito@gmail.com",
        "prioridad": 2
        }
    */

    @GetMapping (path = "/{id}")
    public Optional<UsuarioModel> obtenerUsuarioPorId(@PathVariable("id") Long id){
        return this.usuarioService.obtenerPorId(id);
    }
    /*para buscar el usuario poner en el navegador su id por ejemplo: http://localhost:8080/usuario/3*/

    @GetMapping (path = "/query")
    public ArrayList<UsuarioModel> obtenerUsuarioPorPrioridad(@RequestParam("prioridad") Integer prioridad){
        return this.usuarioService.obtenerPorPrioridad(prioridad);
    }
    /*para buscar el usuario poner en el navegador su prioridad por ejemplo: http://localhost:8080/usuario/query?prioridad=2*/

    @DeleteMapping(path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.usuarioService.eliminarUsuario(id);
        if (ok){
            return "Se eliminó el usuario con id " + id;
        }else{
            return "No se pudo eliminar el usuario con id " + id;
        }
    }
    /*para eliminar un usuario se mete el en postman en la modalidad de
    DELETE una ruta con el id del usuario por ejemplo:
    http://localhost:8080/usuario/1
    y listo, debe regresar el mensaje "Se eliminó el usuario con id 1"*/


}
