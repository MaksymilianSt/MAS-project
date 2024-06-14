package mas.MasBe.Dto;

public record RecipeDTO(
        int id,
        AppUserDTO user,
        String name,
        String description,
        int difficultyLvl,
        int timeToPrepareInMin
        ) {

}
