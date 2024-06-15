package mas.MasBe.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Comment implements IdGenerateable<Comment> {
    @Id
    private int id;
    @NotNull
    private String text;
    private LocalDateTime createdDate;

    @Transient
    public static Set<Comment> extension = new HashSet<>();

    @ManyToOne(optional = false)
    @JoinColumn(name = "app_user_id")
    @NotNull
    private AppUser user;

    @ManyToOne(optional = false)
    @JoinColumn(name = "recipe_id")
    @NotNull
    private Recipe recipe;

    public static Comment createComment(AppUser user, Recipe recipe, String text) {
        if (Objects.isNull(user) || Objects.isNull(recipe)) {
            throw new IllegalArgumentException("user or recipe cannot be null");
        }
        Comment created = new Comment();
        created.setId(created.generateNewId());
        created.setText(text);
        created.setCreatedDate(LocalDateTime.now());
        created.setRecipe(recipe);
        created.setUser(user);

        user.getComments().add(created);
        recipe.getComments().add(created);

        extension.add(created);

        return created;
    }

    @Override
    public Set<Comment> getExtension() {
        return extension;
    }
}
