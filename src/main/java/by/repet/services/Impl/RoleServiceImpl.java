package by.repet.services.Impl;//Created by vladr on 30.04.2017.

import by.repet.domain.Role;
import by.repet.repositories.RoleRepository;
import by.repet.services.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    public Collection<Role> getAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public void remove(Long roleId) {
        roleRepository.delete(roleId);
    }

}
