package mas.MasBe.Service;

import mas.MasBe.Dto.CommentReadDTO;
import mas.MasBe.Model.AppUser;
import mas.MasBe.Model.Recipe;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CommentService {

    public List<CommentReadDTO> getAllByRecipeId(int recipeId) {
//        var user = AppUser.appUserExtesion.stream()
//                .filter(usr -> usr.getId() == userId)
//                .findFirst().orElseThrow(() -> new NoSuchElementException("there is no user with given id: " + userId));

        var recipe = Recipe.recipeExtesion.stream()
                .filter(rec -> rec.getId() == recipeId)
                .findFirst().orElseThrow(() -> new NoSuchElementException("there is no recipe with given id: " + recipeId));

        return recipe.getComments().stream()
                .map(com -> new CommentReadDTO(
                        com.getId(),
                        com.getText(),
                        com.getCreatedDate()
                ))
                .toList();
    }
}
