package mas.MasBe.Model;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class AppUser extends LoginData implements IdGenerateable<AppUser> {
    @Id
    private int id;

    @ElementCollection
    @CollectionTable(name="roles", joinColumns=@JoinColumn(name="app_user_id"))
    @Column(name="roles")
    private Set<UserRoles> roles;
    private LocalDate dateOfBirth;
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

    public void addRecipe(Recipe recipe) {
        if (!recipes.contains(recipe)) {
            recipes.add(recipe);
            recipe.addUser(this);
        }
    }

    public int getAge() {
        return Period.between(LocalDate.now(), dateOfBirth).getYears();
    }

}
