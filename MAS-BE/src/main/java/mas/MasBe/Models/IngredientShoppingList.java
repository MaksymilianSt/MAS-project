package mas.MasBe.Models;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class IngredientShoppingList extends ShoppingList implements DataAnalytics{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDateTime deadline;

    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    @ManyToMany
    private Set<Ingredient> ingredients;
}

