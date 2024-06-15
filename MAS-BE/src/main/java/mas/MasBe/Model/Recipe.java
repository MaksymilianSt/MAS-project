package mas.MasBe.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Recipe implements IdGenerateable<Recipe> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    private String name;
    private String description;
    @NotNull
    private int difficultyLvl;
    @NotNull
    private int timeToPrepareInMin;

    @Transient
    public static Set<Recipe> extension = new HashSet<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "app_user_id")
    private AppUser user;

    @OneToMany(mappedBy = "recipe", fetch = FetchType.EAGER)
    Set<Comment> comments;

    @OneToMany(mappedBy = "recipe", fetch = FetchType.EAGER)
    Set<RecipeLike> likes;

    @OneToMany(mappedBy = "recipe", fetch = FetchType.EAGER)
    private Set<Ingredient> ingredients;


    @Override
    public Set<Recipe> getExtension() {
        return extension;
    }
}
