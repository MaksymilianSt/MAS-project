package mas.MasBe.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class AppUser extends  LoginData{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    //private Set<UserRoles> roles;
    private Date dateOfBirth;

    @Transient
    public static int minAge = 18;

    @OneToMany
    private Set<Recipe> recipes;
}
