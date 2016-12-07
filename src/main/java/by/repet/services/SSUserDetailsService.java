package by.repet.services;//Created by vladr on 27.11.2016.

import by.repet.domain.Role;
import by.repet.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Transactional
public class SSUserDetailsService implements UserDetailsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SSUserDetailsService.class);

    private UserRepository userRepository;

    public SSUserDetailsService(UserRepository userRepository){
        this.userRepository=userRepository;
    }



    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            by.repet.domain.User user = userRepository.findByUsername(username);
            if (user == null) {
                LOGGER.debug("user not found with the provided username");
                return null;
            }
            LOGGER.debug(" user from username " + user.toString());
            return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthorities(user));
        }
        catch (Exception e){
            throw new UsernameNotFoundException("User not found");
        }
    }

    private Set<GrantedAuthority> getAuthorities(by.repet.domain.User user){
        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        for(Role role : user.getRoles()) {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getRole());
            authorities.add(grantedAuthority);
        }
        LOGGER.debug("user authorities are " + authorities.toString());
        return authorities;
    }


}
