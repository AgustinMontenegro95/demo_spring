package com.example.demo.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserDetailDto;
import com.example.demo.models.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepo;

    public List<User> obtenerTodos(){

        List<User> usuarios = userRepo.findAll();

        return usuarios;
    }

    public void cargarUser(User user){
        userRepo.save(user);
    }

    public ResponseEntity<?> obtenerUserDetail(Long id){
        Optional<User> user = userRepo.getUser(id);
        UserDetailDto userDetail = userRepo.getUserDetails(user.get().getId());
        Map<String, Object> responseBody = new  HashMap<>();
        responseBody.put("id", userDetail.getId());
        responseBody.put("name", userDetail.getNombre());
        responseBody.put("email", userDetail.getEmail());
        responseBody.put("provincia", userDetail.getProvincia());
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }
}
