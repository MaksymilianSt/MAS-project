package mas.MasBe.Service;

import io.micrometer.common.util.internal.logging.Slf4JLoggerFactory;
import jakarta.annotation.PreDestroy;
import mas.MasBe.Dto.AppUserDto;
import mas.MasBe.Model.AppUser;
import mas.MasBe.Model.Recipe;
import mas.MasBe.Repository.AppUserRepository;
import mas.MasBe.Repository.RecipeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DbExtensionLoader {

    private static final Logger logger = LoggerFactory.getLogger(DbExtensionLoader.class);
    private RecipeRepository recipeRepository;
    private AppUserRepository appUserRepository;

    public DbExtensionLoader(
            RecipeRepository recipeRepository,
            AppUserRepository appUserRepository
    ) {
        this.recipeRepository = recipeRepository;
        this.appUserRepository= appUserRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void loadData() {
        List<Recipe> recipes = recipeRepository.findAll();
        Recipe.recipeExtesion.addAll(recipes);

        logger.info("data has been loaded");

    }

    @PreDestroy
    public void saveData() {
        recipeRepository.saveAll(Recipe.recipeExtesion);
        logger.info("data has been saved");

    }
}
