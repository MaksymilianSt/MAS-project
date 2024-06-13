package mas.MasBe.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    private String text;
    private LocalDateTime createdDate;


    @ManyToOne(optional = false)
    @JoinColumn(name = "app_user_id")
    @NotNull
    private AppUser user;

    @ManyToOne(optional = false)
    @JoinColumn(name = "recipe_id")
    @NotNull
    private Recipe recipe;
}
