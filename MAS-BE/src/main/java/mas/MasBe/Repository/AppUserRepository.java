package mas.MasBe.Repository;

import mas.MasBe.Model.AppUser;
import mas.MasBe.Model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Integer> {
}
