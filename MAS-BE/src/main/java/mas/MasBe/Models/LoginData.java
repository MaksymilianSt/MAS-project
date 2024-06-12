package mas.MasBe.Models;

import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

@MappedSuperclass
public abstract class LoginData {
    @Email
    @NotNull
    private String email;
    @NotNull
    private String password;
}
