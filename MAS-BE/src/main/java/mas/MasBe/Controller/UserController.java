package mas.MasBe.Controller;

import mas.MasBe.Dto.LoginData;
import mas.MasBe.Dto.UserDTO;
import mas.MasBe.Service.LoginService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    private LoginService loginService;

    public UserController(LoginService loginService){
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public ResponseEntity<UserDTO> login(@RequestBody LoginData loginData) {
        UserDTO logged = loginService.login(loginData.email(), loginData.password());
        return ResponseEntity.ok(logged);
    }
}
