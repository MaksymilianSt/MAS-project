package mas.MasBe.Repository;

import mas.MasBe.Model.AppUser;
import mas.MasBe.Model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
