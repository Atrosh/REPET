package by.repet.repositories;//Created by vladr on 25.04.2017.

import by.repet.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Set<Role> findAllByRole(String role);
}
