package by.repet.security;

import by.repet.domain.User;

import java.util.Collection;
import java.util.Optional;

/**
 * 
 * @author vladimir.stankovic
 *
 * Aug 17, 2016
 */
public interface UserService {
    public Optional<User> getByUsername(String username);
    User getUser(Long userId);
    Collection<User> getAll();
    User add(User user);
    void remove(Long userId);
}
