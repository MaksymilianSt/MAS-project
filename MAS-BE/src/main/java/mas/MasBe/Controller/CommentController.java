package mas.MasBe.Controller;

import mas.MasBe.Dto.CommentReadDTO;
import mas.MasBe.Service.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class CommentController {

    private CommentService commentService;

    public CommentController(CommentService commentService){
        this.commentService = commentService;
    }
    @GetMapping("/user/{userId}/recipe/{recipeId}")
    public ResponseEntity<Collection<CommentReadDTO>> getAll(@PathVariable Integer userId,@PathVariable Integer recipeId) {
        var comments = commentService.getAllByRecipeId(recipeId);
        return ResponseEntity.ok(comments);
    }
}
