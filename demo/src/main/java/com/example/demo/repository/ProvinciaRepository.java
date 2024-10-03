package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Provincia;

public interface ProvinciaRepository extends JpaRepository<Provincia, Long>{
    
}
