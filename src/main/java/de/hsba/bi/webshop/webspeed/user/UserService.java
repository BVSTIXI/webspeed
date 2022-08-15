package de.hsba.bi.webshop.webspeed.user;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

    public void init() {
        userRepository.save(new User("Jakob"));
        userRepository.save(new User("Niklas"));
        userRepository.save(new User("Bolat"));
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    //public User findCurrentUser() {
        //return userRepository.findByName(User.getCurrentUsername());
    //}
}
