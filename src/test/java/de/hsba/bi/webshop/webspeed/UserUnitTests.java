package de.hsba.bi.webshop.webspeed;

import de.hsba.bi.webshop.webspeed.user.User;
import de.hsba.bi.webshop.webspeed.user.UserRepository;
import de.hsba.bi.webshop.webspeed.user.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoSettings;

import java.util.List;

@MockitoSettings
public class UserUnitTests {

    @Mock
    UserRepository userRepositoryMock;

    @InjectMocks
    UserService userServiceMock;

    @Test
    public List<User> findAllUsers() {
        return userRepositoryMock.findAll();
    }

    @Test
    public User findCurrentUser() {
        return userRepositoryMock.findByUserName(User.getCurrentUsername());
    }
}
