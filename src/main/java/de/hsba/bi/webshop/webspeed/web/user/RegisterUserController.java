package de.hsba.bi.webshop.webspeed.web.user;

import de.hsba.bi.webshop.webspeed.WebSecurityConfig;
import de.hsba.bi.webshop.webspeed.user.User;
import de.hsba.bi.webshop.webspeed.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

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
    //TODO aus irgendeinem Grund muss man sich nach dem ausfüllen des Forms anmelden. Wieso?
    @PostMapping
    public RedirectView create(@RequestParam(name="name")String name,@RequestParam(name="userName") String userName,@RequestParam(name="password") String password) {
        String hashedPassword = WebSecurityConfig.passwordEncoder().encode(password);
        userService.createUser(name, userName, hashedPassword);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/allproducts");
        return redirectView;
    }
    @GetMapping(path="/{id}")
    public String show (@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.findAllUsers());
        return "user/user";
    }
}
