package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Provincia;
import com.example.demo.repository.ProvinciaRepository;

@Service
public class ProvinciaService {
    @Autowired
    private ProvinciaRepository provRepo;

    public List<Provincia> obtenerProvincias(){
        return provRepo.findAll();  
    }

    public void cargarProvincia(Provincia provincia) {
        provRepo.save(provincia);        
    }
}
