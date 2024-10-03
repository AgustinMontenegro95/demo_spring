package com.example.demo.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user-detalle")
public class UserDetailDto {
    @Id
    private Long id;
    //@Column(name = "user_nombre")
    private String nombre;
    //@Column(name = "user_email")
    private String email;
    //@Column(name = "prov_nombre")
    private String provincia;
}
