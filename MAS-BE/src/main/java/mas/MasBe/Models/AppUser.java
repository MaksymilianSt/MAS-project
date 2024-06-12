package mas.MasBe.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @OneToMany(mappedBy = "user")
    private Set<Recipe> recipes;

    @OneToMany(mappedBy = "user")
    Set<Comment> comments;

    @OneToMany(mappedBy = "user")
    Set<RecipeLike> likes;
}
