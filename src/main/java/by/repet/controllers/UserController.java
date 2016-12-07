package by.repet.controllers;//Created by vladr on 27.11.2016.

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@PreAuthorize("hasAuthority('USER')")
public class UserController {
    @RequestMapping("")
    public String home(){
        return "Hello :: This is user home";
    }
}
