package by.repet.services;//Created by vladr on 30.04.2017.

import by.repet.domain.Role;

import java.util.Collection;

public interface RoleService {
    Collection<Role> getAll();

    Role save(Role role);

    void remove(Long roleId);
}
