package mas.MasBe.Dto;

import mas.MasBe.Model.Ingredient;

import java.util.Set;

public record IngredientDTO(
        int id,
        String name,
        int quantity
        ) {

}
