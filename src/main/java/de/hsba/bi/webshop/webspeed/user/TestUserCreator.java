//package de.hsba.bi.webshop.webspeed.user;
//
//import de.hsba.bi.webshop.webspeed.product.Product;
//import lombok.RequiredArgsConstructor;
//import org.springframework.boot.context.event.ApplicationStartedEvent;
//import org.springframework.context.event.EventListener;
//import org.springframework.stereotype.Component;
//
//import javax.transaction.Transactional;
//import java.math.BigDecimal;
//
//@Component
//@RequiredArgsConstructor
//@Transactional
//public class TestUserCreator {
//
//    private final UserRepository userRepository;
//
//    @EventListener(ApplicationStartedEvent.class)
//    public void init() {
//        User testUser = userRepository.save(new User("Jakob","TestUser","12345"));
//    }
//
//}
