package mas.MasBe.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Article implements DataAnalytics {

    @Id
    private int id;
    @NotNull
    private String title;
    @NotNull
    private String text;
    @NotNull
    private String author;
    @NotNull
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    public static Set<Article> extension;

    public void displayAllArticles() {
        extension.forEach(System.out::println);
    }

}
