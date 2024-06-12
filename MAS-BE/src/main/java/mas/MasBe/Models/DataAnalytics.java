package mas.MasBe.Models;

import java.time.LocalDateTime;

public interface DataAnalytics {

    LocalDateTime getCreatedDate();
    void setCreatedDate(LocalDateTime createdDate);

    LocalDateTime getUpdatedDate();
    void setUpdatedDate(LocalDateTime updatedDate);
}
