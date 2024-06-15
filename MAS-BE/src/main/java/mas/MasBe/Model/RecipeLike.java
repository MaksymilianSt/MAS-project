package mas.MasBe.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class RecipeLike implements IdGenerateable<RecipeLike> {
    @Id
    private int id;

    private LocalDateTime createdDate;


    @ManyToOne(optional = false)
    @JoinColumn(name = "app_user_id")
    private AppUser user;

    @ManyToOne(optional = false)
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

    public static Set<RecipeLike> extension = new HashSet<>();

    @Override
    public Set<RecipeLike> getExtension() {
        return extension;
    }

    public static RecipeLike createRecipeLike(AppUser user, Recipe recipe) {
        if (Objects.isNull(user) || Objects.isNull(recipe)) {
            throw new IllegalArgumentException("user or recipe cannot be null");
        }
        RecipeLike created = new RecipeLike();
        created.setId(created.generateNewId());
        created.setCreatedDate(LocalDateTime.now());
        created.setRecipe(recipe);
        created.setUser(user);

        user.getLikes().add(created);
        recipe.getLikes().add(created);

        extension.add(created);

        return created;
    }
}
