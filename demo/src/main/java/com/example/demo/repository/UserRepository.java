package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.dto.UserDetailDto;
import com.example.demo.models.User;
import java.util.*;


public interface UserRepository extends JpaRepository<User, Long>{

    public UserDetailDto getUserDetails(@Param("id") Long id);

    @Query(value = "SELECT u.id, u.name, u.email, u.id_provincia FROM usuario u WHERE u.id = :id", nativeQuery = true)
    public Optional<User> getUser(@Param("id") Long id);
}
