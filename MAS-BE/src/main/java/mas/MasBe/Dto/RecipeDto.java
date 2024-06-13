package mas.MasBe.Dto;

public record RecipeDto(
        int id,
        AppUserDto user,
        String name,
        String description,
        int difficultyLvl,
        int timeToPrepareInMin
        ) {

}
