package de.hsba.bi.webshop.webspeed.web.user;

import de.hsba.bi.webshop.webspeed.WebSecurityConfig;
import de.hsba.bi.webshop.webspeed.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

//Diese Klasse verbindet die Logikklassen mit dem Frontend der Registrieren-Seite
@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class RegisterUserController {

    //Abhängigkeit
    private final UserService userService;

    //Diese Funktion mappt die findAllUsers() Funktion zur user Seite
    @GetMapping
    public String index(Model model) {
        model.addAttribute("user", userService.findAllUsers());
        return "user/user";
    }

    //Diese Funktion mappt eine PostRequest auf der user Seite, über die die Nutzerinformationen an die createUser() Funktion übergeben werden
    //Danach wird der Nutzer auf die allProducts Seite weitergeleitet
    @PostMapping
    public RedirectView create(@RequestParam(name="name")String name,@RequestParam(name="userName") String userName,@RequestParam(name="password") String password) {
        String hashedPassword = WebSecurityConfig.passwordEncoder().encode(password);
        userService.createUser(name, userName, hashedPassword);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/login");
        return redirectView;
    }

    //Diese Funktion mappt die findAllUsers() Funktion zur user Seite
    @GetMapping(path="/{id}")
    public String show (@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.findAllUsers());
        return "user/user";
    }
}
