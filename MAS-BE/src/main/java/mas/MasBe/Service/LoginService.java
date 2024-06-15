package mas.MasBe.Service;

import lombok.extern.slf4j.Slf4j;
import mas.MasBe.Dto.UserDTO;
import mas.MasBe.Model.AppUser;
import mas.MasBe.Model.UserRoles;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@Slf4j
public class LoginService {

    public UserDTO login(String email, String password) {
        log.info("logging user:" + email);
        AppUser user = AppUser.extesion.stream()
                .filter(usr -> usr.getEmail().equals(email.trim()) && usr.getPassword().equals(password.trim()))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("bad credentials"));

        //user.getRoles().add(UserRoles.USER);
        return new UserDTO(user.getId(), user.getEmail(), user.getRoles());
    }
}
