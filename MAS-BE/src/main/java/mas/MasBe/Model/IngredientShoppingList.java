package mas.MasBe.Model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class IngredientShoppingList extends ShoppingList implements DataAnalytics, IdGenerateable<IngredientShoppingList> {

    @Id
    private int id;

    private LocalDateTime deadline;

    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    @ManyToMany
    private Set<Ingredient> ingredients = new HashSet<>();
    public static Set<IngredientShoppingList> extension;

    public void addIngredient(Ingredient ingredient) {
        if (!ingredients.contains(ingredient)) {
            ingredients.add(ingredient);
            ingredient.addIngredientShoppingList(this);
        }
    }

    public static IngredientShoppingList createIngredientShoppingList(LocalDateTime deadline, Ingredient ingredient) {
        // ik but, hibernate needs public constructor :((
        if (deadline == null || ingredient == null) {
            throw new IllegalArgumentException("cannot create list without ingredient");
        }

        IngredientShoppingList created = new IngredientShoppingList();
        created.setId(created.generateNewId());
        created.addIngredient(ingredient);
        created.setDeadline(deadline);
        created.setCreatedDate(LocalDateTime.now());
        extension.add(created);

        return created;
    }

    @Override
    public void display() {
        System.out.println("name:" + name + " deadline: " + deadline);
    }

    @Override
    public Set<IngredientShoppingList> getExtension() {
        return extension;
    }
}

