package by.repet.controllers;//Created by vladr on 27.11.2016.

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminController {

    @RequestMapping("")
    public String home(){
        return "Hello :: This is admin home";
    }
}
