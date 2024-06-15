package mas.MasBe.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    private String name;
    @NotNull
    private int quantity;

    @ManyToMany
    private Set<IngredientShoppingList> ingredientShoppingLists;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "recipe_id")
    @NotNull()
    private Recipe recipe;

    public void addIngredientShoppingList(IngredientShoppingList ingredientShoppingList){
        if(!ingredientShoppingLists.contains(ingredientShoppingList)){
            ingredientShoppingLists.add(ingredientShoppingList);
            ingredientShoppingList.addIngredient(this);
        }
    }
}
