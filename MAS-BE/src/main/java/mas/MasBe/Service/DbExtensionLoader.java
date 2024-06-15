package mas.MasBe.Service;

import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;
import mas.MasBe.Model.AppUser;
import mas.MasBe.Model.Comment;
import mas.MasBe.Model.Recipe;
import mas.MasBe.Repository.AppUserRepository;
import mas.MasBe.Repository.CommentRepository;
import mas.MasBe.Repository.RecipeRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DbExtensionLoader {


    private RecipeRepository recipeRepository;
    private AppUserRepository appUserRepository;
    CommentRepository commentRepository;

    public DbExtensionLoader(
            RecipeRepository recipeRepository,
            AppUserRepository appUserRepository,
            CommentRepository commentRepository
    ) {
        this.recipeRepository = recipeRepository;
        this.appUserRepository= appUserRepository;
        this.commentRepository = commentRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void loadData() {
        Recipe.extension.addAll(recipeRepository.findAll());
        AppUser.extesion.addAll(appUserRepository.findAll());
        Comment.extension.addAll(commentRepository.findAll());

        log.info("data has been loaded");

    }

    @PreDestroy
    public void saveData() {
        appUserRepository.saveAll(AppUser.extesion);
        recipeRepository.saveAll(Recipe.extension);
        commentRepository.saveAll(Comment.extension);
        log.info("data has been saved");

    }
}
