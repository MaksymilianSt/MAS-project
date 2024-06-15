package mas.MasBe.Model;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class AppUser extends  LoginData implements IdGenerateable<AppUser> {
    @Id
    private int id;
    //private Set<UserRoles> roles;
    private Date dateOfBirth;
    @Transient
    public static int minAge = 18;
    @Transient
    public static Set<AppUser> extesion = new HashSet<>();


    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private Set<Recipe> recipes;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    Set<Comment> comments;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    Set<RecipeLike> likes;

    @Override
    public Set<AppUser> getExtension() {
        return extesion;
    }
}
