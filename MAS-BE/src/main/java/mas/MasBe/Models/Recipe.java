package mas.MasBe.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Recipe {
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "app_user_id")
    private AppUser user;

    @OneToMany(mappedBy = "recipe")
    Set<Comment> comments;

    @OneToMany(mappedBy = "recipe")
    Set<RecipeLike> likes;

}
