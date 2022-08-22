package de.hsba.bi.webshop.webspeed.web.user;

import de.hsba.bi.webshop.webspeed.user.User;
import de.hsba.bi.webshop.webspeed.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class RegisterUserController {

    private final UserService userService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("user", userService.findAllUsers());
        return "user/user";
    }
    @PostMapping
    public String create(@RequestParam(name="name")String name,@RequestParam(name="userName") String userName,@RequestParam(name="password") String password) {
        User user = userService.createUser(name, userName, password);
        return "redirect:/user/";
    }
    @GetMapping(path="/{id}")
    public String show (@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.findAllUsers());
        return "user/user";
    }
}
