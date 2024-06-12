package mas.MasBe.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class RecipeLike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDateTime createdDate;


    @ManyToOne()
    @JoinColumn(name = "app_user_id")
    private AppUser user;

    @ManyToOne()
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;
}
