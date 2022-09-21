package de.hsba.bi.webshop.webspeed.user;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class UserService {
    private  final UserRepository userRepository;

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public User getUser(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    //TODO Error message o.ä. wenn was schief geht (z.B. kein Username eingetragen oder whatever)
    public User createUser(String name, String userName, String password) {
        User user = new User();
        user.setName(name);
        user.setUserName(userName);
        user.setPassword(password);
        return userRepository.save(user);
    }


    public User findCurrentUser() {
        return userRepository.findByUserName(User.getCurrentUsername());
    }
}
