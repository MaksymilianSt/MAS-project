package mas.MasBe.Model;

import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public abstract class LoginData {
    @Email
    @NotNull
    private String email;
    @NotNull
    private String password;
}
