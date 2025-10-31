package poly.edu.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Account {
    @Id
    private String username;
    private String password;
    private String fullname;
    private String email;
    private String role; // có thể là "USER" hoặc "ADMIN"
}
