package pj.techrentalsystem.Contollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pj.techrentalsystem.DTOs.UserDto;
import pj.techrentalsystem.Services.UserService;

@Controller
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("userDto") UserDto userDto){
        userService.addUser(userDto);
        return "redirect:/login?success";
    }
}
