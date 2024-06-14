package mas.MasBe.Dto;



import java.util.Set;

public record RecipeDTO(
        int id,
        AppUserDTO user,
        String name,
        String description,
        int difficultyLvl,
        int timeToPrepareInMin,
        Set<IngredientDTO> ingredients
        ) {

}
