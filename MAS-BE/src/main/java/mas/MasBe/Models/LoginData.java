package mas.MasBe.Models;

import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class LoginData {

    private String email;
    private String password;
}
