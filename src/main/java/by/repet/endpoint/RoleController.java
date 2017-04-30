package by.repet.endpoint;//Created by vladr on 30.04.2017.

import by.repet.domain.Role;
import by.repet.services.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@AllArgsConstructor
@RequestMapping("api/role")
public class RoleController {

    private final RoleService roleService;

    @GetMapping
    public Collection<Role> getRoles() {
        return roleService.getAll();
    }

}
