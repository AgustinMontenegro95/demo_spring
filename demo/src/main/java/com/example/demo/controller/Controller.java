package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

//import com.example.demo.dto.UserDetailDto;
import com.example.demo.models.Provincia;
import com.example.demo.models.User;
import com.example.demo.service.ProvinciaService;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
public class Controller {
    @Autowired
    private UserService userServ;
    @Autowired
    private ProvinciaService provServ;

    @GetMapping("/usuarios")
    public List<User> obtenerUsuarios() {
        return (List<User>) userServ.obtenerTodos();
    }

    @PostMapping("/crear-usuario")
    public User crearUsuario(@RequestBody User user) {
        userServ.cargarUser(user);
        return user;
    }
    @GetMapping("/provincias")
    public List<Provincia> obtenerProvincias() {
        return (List<Provincia>) provServ.obtenerProvincias();
    }

    @PostMapping("/crear-provincia")
    public Provincia crearProvincia(@RequestBody Provincia provincia) {
        provServ.cargarProvincia(provincia);
        return provincia;
    }

    @GetMapping("/user-detail")
    public ResponseEntity<?> obtenerUserDetail(@RequestParam Long id){
        return userServ.obtenerUserDetail(id);
    }
    

    
}
