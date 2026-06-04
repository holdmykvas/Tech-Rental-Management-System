package pj.techrentalsystem.Contollers;

import org.springframework.stereotype.Controller;
import pj.techrentalsystem.Services.UserService;

@Controller
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }
}
