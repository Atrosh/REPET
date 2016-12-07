package by.repet.repositories;//Created by vladr on 27.11.2016.

import by.repet.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
