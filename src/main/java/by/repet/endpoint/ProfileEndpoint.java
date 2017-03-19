package by.repet.endpoint;

import by.repet.domain.User;
import by.repet.security.UserService;
import by.repet.security.auth.JwtAuthenticationToken;
import by.repet.security.model.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

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

    @RequestMapping(value = "/api/me", method = RequestMethod.GET)
    @ResponseBody
    public User get(JwtAuthenticationToken token) {
        UserContext userContext = (UserContext) token.getPrincipal();
        return userService.getByUsername(userContext.getUsername()).orElseThrow(() -> new UsernameNotFoundException("User not found: " + userContext.getUsername()));
    }
}
