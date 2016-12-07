package by.repet.config;//Created by vladr on 06.12.2016.

import by.repet.services.SSUserDetailsService;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.User;
import io.jsonwebtoken.Jwts;

public final class TokenHandler {

    private final String secret;
    private final SSUserDetailsService userService;

    public TokenHandler(String secret, SSUserDetailsService userService) {
        this.secret = secret;
        this.userService = userService;
    }

    public User parseUserFromToken(String token) {
        String username = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
        return userService.loadUserByUsername(username);
    }

    public String createTokenForUser(User user) {
        return Jwts.builder()
                .setSubject(user.getUsername())
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }
}
