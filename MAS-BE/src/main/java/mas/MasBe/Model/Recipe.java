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
    Set<Comment> comments = new HashSet<>();

    @OneToMany(mappedBy = "recipe", fetch = FetchType.EAGER)
    Set<RecipeLike> likes;

    @OneToMany(mappedBy = "recipe", fetch = FetchType.EAGER)
    private Set<Ingredient> ingredients;


    @Override
    public Set<Recipe> getExtension() {
        return extension;
    }

    public void addIngredient(Ingredient ingredient) {
        if (!ingredients.contains(ingredient)) {
            ingredients.add(ingredient);
            ingredient.addRecipe(this);
        }
    }

    public void addUser(AppUser user) {
        this.user = user;
        user.addRecipe(this);
    }

    public static Recipe createIngredient(String name, String description, int difficultyLvl, int timeToPrepareInMin, AppUser user) {
        // ik but, hibernate needs public constructor :((
        if (name == null || name.isEmpty() || user == null) {
            throw new IllegalArgumentException("cannot create Recipe without user");
        }

        Recipe created = new Recipe();
        created.setId(created.generateNewId());
        created.setName(name);
        created.setDescription(description);
        created.setDifficultyLvl(difficultyLvl);
        created.setTimeToPrepareInMin(timeToPrepareInMin);

        created.addUser(user);

        extension.add(created);

        return created;
    }
}
