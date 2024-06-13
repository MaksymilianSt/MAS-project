package mas.MasBe.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class AppUser extends  LoginData{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    //private Set<UserRoles> roles;
    private Date dateOfBirth;

    @Transient
    public static int minAge = 18;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private Set<Recipe> recipes;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    Set<Comment> comments;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    Set<RecipeLike> likes;
}
