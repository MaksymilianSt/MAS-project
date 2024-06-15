package mas.MasBe.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Ingredient implements IdGenerateable<Ingredient> {
    @Id
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

    public static Set<Ingredient> extension = new HashSet<>();

    public void addIngredientShoppingList(IngredientShoppingList ingredientShoppingList) {
        if (!ingredientShoppingLists.contains(ingredientShoppingList)) {
            ingredientShoppingLists.add(ingredientShoppingList);
            ingredientShoppingList.addIngredient(this);
        }
    }

    public void addRecipe(Recipe recipe) {
        this.setRecipe(recipe);
        recipe.addIngredient(this);
    }

    public static Ingredient createIngredient(String name, int quantity, Recipe recipe) {
        // ik but, hibernate needs public constructor :((
        if (name == null || name.isEmpty() || recipe == null) {
            throw new IllegalArgumentException("cannot create ingredient without recipe");
        }

        Ingredient created = new Ingredient();
        created.setId(created.generateNewId());
        created.setName(name);
        created.setQuantity(quantity);

        created.addRecipe(recipe);

        extension.add(created);

        return created;
    }

    @Override
    public Set<Ingredient> getExtension() {
        return extension;
    }
}
