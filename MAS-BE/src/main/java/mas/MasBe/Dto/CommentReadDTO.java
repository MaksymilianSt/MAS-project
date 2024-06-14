package mas.MasBe.Dto;

import java.time.LocalDateTime;

public record CommentReadDTO(
        int id,
        String text,
        LocalDateTime createdDate
) {
}
