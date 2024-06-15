package mas.MasBe.Dto;

import mas.MasBe.Model.UserRoles;

import java.util.Set;

public record UserDTO(int id, String email, Set<UserRoles> roles) {
}
