package mas.MasBe.Controller;

import mas.MasBe.Dto.AppUserDto;
import mas.MasBe.Dto.RecipeDto;
import mas.MasBe.Model.Recipe;
import mas.MasBe.Repository.AppUserRepository;
import mas.MasBe.Repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/recipe")
public class RecipeController {


    private AppUserRepository appUserRepository;

    public RecipeController(AppUserRepository appUserRepository){
        this.appUserRepository = appUserRepository;
    }
    @GetMapping
    public Collection<RecipeDto> getAll() {
        return Recipe.recipeExtesion.stream()
                .map(recipe -> {
                    var user = recipe.getUser();
                    return new RecipeDto(
                            recipe.getId(),
                            new AppUserDto(user.getId(), user.getEmail(), user.getPassword()),
                            recipe.getName(),
                            recipe.getDescription(),
                            recipe.getDifficultyLvl(),
                            recipe.getTimeToPrepareInMin()
                    );
                }).toList();
    }

    @PostMapping
    public String save(@RequestBody RecipeDto recipeDto) {
        Recipe newRecipe = new Recipe();
        newRecipe.setUser(appUserRepository.findById(recipeDto.user().id()).get());
        newRecipe.setName(recipeDto.name());
        newRecipe.setDescription(recipeDto.description());
        newRecipe.setDifficultyLvl(recipeDto.difficultyLvl());
        newRecipe.setTimeToPrepareInMin(recipeDto.timeToPrepareInMin());
        Recipe.recipeExtesion.add(newRecipe);
        return "git";
    }
}
