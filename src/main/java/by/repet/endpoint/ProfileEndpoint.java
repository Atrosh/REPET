package by.repet.endpoint;

import by.repet.domain.User;
import by.repet.security.UserService;
import by.repet.security.auth.JwtAuthenticationToken;
import by.repet.security.model.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * End-point for retrieving logged-in user details.
 *
 * @author vladimir.stankovic
 *         <p>
 *         Aug 4, 2016
 */
@RestController
public class ProfileEndpoint {

    private final UserService userService;

    @Autowired
    public ProfileEndpoint(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/api/me")
    @ResponseBody
    public User get(JwtAuthenticationToken token) {
        UserContext userContext = (UserContext) token.getPrincipal();
        return userService.getByUsername(userContext.getUsername()).orElseThrow(() -> new UsernameNotFoundException("User not found: " + userContext.getUsername()));
    }

    @PostMapping("/api/user")
    public User createUser(@RequestBody User user) {
        return userService.add(user);
    }

    @DeleteMapping("/api/user/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        userService.remove(userId);
    }

    @GetMapping("/api/user/all")
    @ResponseBody
    public Collection<User> getAll() {
        return userService.getAll();
    }
}
