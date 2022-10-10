package de.hsba.bi.webshop.webspeed.user;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

//Diese Klasse beinhaltet die Logikoperationen in Bezug auf Userobjekte
@RequiredArgsConstructor
@Service
@Transactional
public class UserService {

    //Abhängigkeiten
    private  final UserRepository userRepository;

    //Diese Funktion gibt alle in der Datenbank eingetragenen User wieder
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    //Diese Funktion
    public User save(User user) {
        return userRepository.save(user);
    }

    public User getUser(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    //Diese Funktion erzeugt einen User durch Eingaben auf der Registrieren-Seite und speichert ihn in der Datenbank
    public User createUser(String name, String userName, String password) {
        User user = new User();
        user.setName(name);
        user.setUserName(userName);
        user.setPassword(password);
        return userRepository.save(user);
    }

    //Diese Funktion gibt den aktuell angemeldeten User wieder
    public User findCurrentUser() {
        return userRepository.findByUserName(User.getCurrentUsername());
    }
}
