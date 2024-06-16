package mas.MasBe.Controller;

import mas.MasBe.Dto.AppUserDTO;
import mas.MasBe.Dto.CommentReadDTO;
import mas.MasBe.Dto.IngredientDTO;
import mas.MasBe.Dto.RecipeDTO;
import mas.MasBe.Model.Recipe;
import mas.MasBe.Repository.AppUserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/recipe")
public class RecipeController {


    private AppUserRepository appUserRepository;

    public RecipeController(AppUserRepository appUserRepository){
        this.appUserRepository = appUserRepository;
    }
    @GetMapping
    public Collection<RecipeDTO> getAll() {
        return Recipe.extension.stream()
                .map(recipe -> {
                    var user = recipe.getUser();
                    var ingredientDTOs = recipe.getIngredients().stream()
                            .map(ing -> new IngredientDTO(ing.getId(), ing.getName(), ing.getQuantity()))
                            .collect(Collectors.toSet());

                    var comments = recipe.getComments().stream()
                            .map(com -> new CommentReadDTO(
                                    com.getId(),
                                    com.getText(),
                                    com.getCreatedDate()
                            )).collect(Collectors.toSet());

                    return new RecipeDTO(
                            recipe.getId(),
                            new AppUserDTO(user.getId(), user.getEmail(), user.getPassword()),
                            recipe.getName(),
                            recipe.getDescription(),
                            recipe.getDifficultyLvl(),
                            recipe.getTimeToPrepareInMin(),
                            ingredientDTOs,
                            comments
                    );
                }).toList();
    }

}
