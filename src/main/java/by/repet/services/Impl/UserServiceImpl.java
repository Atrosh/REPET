package by.repet.services.Impl;//Created by vladr on 27.11.2016.

import by.repet.domain.User;
import by.repet.repositories.RoleRepository;
import by.repet.repositories.UserRepository;
import by.repet.security.UserService;
import by.repet.security.model.UserContext;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private static final String ROLE_USER = "ROLE_USER";

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder encoder;


    @Override
    public Optional<User> getByUsername(String username) {
        return this.userRepository.findByUsername(username);
    }

    @Override
    public User getUser(Long userId) {
        return userRepository.findOne(userId);
    }

    @Override
    public Collection<User> getAll() {
        return roleRepository.findAllByRole(ROLE_USER).iterator().next().getUsers();
    }

    @Override
    public User add(User user) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = ((UserContext) auth.getPrincipal()).getUsername();
        Optional<User> currentUser = userRepository.findByUsername(name);
        user.setOrganisation(currentUser.get().getOrganisation());
        user.setRoles(roleRepository.findAllByRole(ROLE_USER));
        user.setPassword(encoder.encode(user.getPassword()));
        user.setEnabled(true);
        return userRepository.save(user);
    }

    @Override
    public void remove(Long userId) {
        userRepository.delete(userId);
    }

}
