package mas.MasBe.Model;


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

    public void addIngredient(Ingredient ingredient){
        if(!ingredients.contains(ingredient)){
            ingredients.add(ingredient);
            ingredient.addIngredientShoppingList(this);
        }
    }
    //constructor needs to have ingr cause 1..* relation, pousuwac @GenerationType.IDentioty na samo @ID

}

