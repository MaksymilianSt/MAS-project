package mas.MasBe.Model;

import java.util.Collection;
import java.util.Set;

public interface IdGenerateable <T extends IdGenerateable> {
    int getId();
    Set<T> getExtension();

    default int generateNewId() {
        return getExtension().stream()
                .map(IdGenerateable::getId)
                .max(Integer::compare)
                .orElse(0) + 1;
    }
}
