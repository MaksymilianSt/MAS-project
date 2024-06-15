package mas.MasBe.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.HashSet;
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

    public Comment(AppUser user, Recipe recipe, String text){
        this.setId(generateNewId());
        this.setUser(user);
        this.setRecipe(recipe);
        this.setText(text);
        this.createdDate = LocalDateTime.now();

        user.getComments().add(this);
        recipe.getComments().add(this);

        extension.add(this);
    }

    @Override
    public Set<Comment> getExtension() {
        return extension;
    }

}
