package mas.MasBe.Model;

import java.time.LocalDateTime;

public interface DataAnalytics {

    LocalDateTime getCreatedDate();
    void setCreatedDate(LocalDateTime createdDate);

    LocalDateTime getUpdatedDate();
    void setUpdatedDate(LocalDateTime updatedDate);
}
