package mas.MasBe.Controller;

import mas.MasBe.Dto.CommentReadDTO;
import mas.MasBe.Service.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Collection;

@RestController
public class CommentController {

    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/recipe/{recipeId}/comment")
    public ResponseEntity<Collection<CommentReadDTO>> getAllByRecipeId(@PathVariable Integer recipeId) {
        var comments = commentService.getAllByRecipeId(recipeId);
        return ResponseEntity.ok(comments);
    }

    @GetMapping("/user/{userId}/comment")
    public ResponseEntity<Collection<CommentReadDTO>> getAll(@PathVariable Integer userId) {
        var comments = commentService.getAllByUserId(userId);
        return ResponseEntity.ok(comments);
    }

    @PostMapping("/user/{userId}/recipe/{recipeId}/comment")
    public ResponseEntity<CommentReadDTO> save(
            @PathVariable Integer userId,
            @PathVariable Integer recipeId,
            @RequestBody String text) {
        var created = commentService.save(userId, recipeId, text);
        return ResponseEntity
                .created(URI.create("/recipe/" + recipeId + "/comment/" + created.id()))
                .body(created);
    }
}
