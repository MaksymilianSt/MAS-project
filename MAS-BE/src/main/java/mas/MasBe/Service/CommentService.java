package mas.MasBe.Service;

import lombok.extern.slf4j.Slf4j;
import mas.MasBe.Dto.CommentReadDTO;
import mas.MasBe.Model.AppUser;
import mas.MasBe.Model.Comment;
import mas.MasBe.Model.Recipe;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
@Service
public class CommentService {

    public List<CommentReadDTO> getAllByRecipeId(int recipeId) {
        log.info("getting all comments for recipeId:" + recipeId);

        var recipe = Recipe.extension.stream()
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

    public List<CommentReadDTO> getAllByUserId(int userId) {
        log.info("getting all comments for userId:" + userId);

        var user = AppUser.extesion.stream()
                .filter(usr -> usr.getId() == userId)
                .findFirst().orElseThrow(() -> new NoSuchElementException("there is no user with given id: " + userId));

        return user.getComments().stream()
                .map(com -> new CommentReadDTO(
                        com.getId(),
                        com.getText(),
                        com.getCreatedDate()
                ))
                .toList();
    }

    public CommentReadDTO save(int userId, int recipeId, String text){
        var user = AppUser.extesion.stream()
                .filter(usr -> usr.getId() == userId)
                .findFirst().orElseThrow(() -> new NoSuchElementException("there is no user with given id: " + userId));

        var recipe = Recipe.extension.stream()
                .filter(rec -> rec.getId() == recipeId)
                .findFirst().orElseThrow(() -> new NoSuchElementException("there is no recipe with given id: " + recipeId));

        Comment comment = new Comment(user, recipe, text);
        return new CommentReadDTO(comment.getId(), comment.getText(), comment.getCreatedDate());
    }
}
