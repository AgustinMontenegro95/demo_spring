package com.example.demo.models;

import com.example.demo.dto.UserDetailDto;

import jakarta.persistence.Column;
import jakarta.persistence.ColumnResult;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.SqlResultSetMapping;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "usuario")
@SqlResultSetMapping(name = "UserDetailDtoMapping", 
    classes = @ConstructorResult(
        targetClass = UserDetailDto.class,
        columns = {
            @ColumnResult(name = "id", type = Integer.class),
            @ColumnResult(name = "nombre", type = String.class),
            @ColumnResult(name = "email", type = String.class),
            @ColumnResult(name = "provincia", type = String.class),
        }))
@NamedNativeQuery(name = "User.getUserDetails",
                resultClass = UserDetailDto.class,
                resultSetMapping = "UserDetailMapping",
                query = """
                        SELECT u.id, u.name AS nombre, u.email AS email, p.nombre_prov AS provincia
                        FROM usuario u 
                        INNER JOIN provincia p
                        WHERE u.id = :id
                        """
)
public class User {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "id_provincia")
    private Long idProvincia;
    
    public User(Long id, String name, String email) {
        this.name = name;
        this.email = email;
    }

}
