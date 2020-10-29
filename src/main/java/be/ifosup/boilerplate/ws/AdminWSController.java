package be.ifosup.boilerplate.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import be.ifosup.boilerplate.models.UserDTO;
import be.ifosup.boilerplate.services.UsersService;

/**
 * Admin controller
 */
@RestController
@RequestMapping("/ws/admin")
public class AdminWSController {

    private final UsersService usersService;

    @Autowired
    public AdminWSController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping
    public UserDTO adminPage() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        return usersService.getUser(username);
    }
}
