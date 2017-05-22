package by.repet.services.Impl;//Created by vladr on 23.05.2017.

import by.repet.domain.User;
import by.repet.repositories.UserRepository;
import by.repet.security.model.UserContext;
import by.repet.services.UserContextService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserContextServiceImpl implements UserContextService {

    private final UserRepository userRepository;

    @Override
    public User getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = ((UserContext) auth.getPrincipal()).getUsername();
        Optional<User> currentUser = userRepository.findByUsername(name);
        return currentUser.get();
    }
}
