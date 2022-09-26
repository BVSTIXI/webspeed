package de.hsba.bi.webshop.webspeed.product;

import de.hsba.bi.webshop.webspeed.sale.Sale;
import de.hsba.bi.webshop.webspeed.sale.SaleRepository;
import de.hsba.bi.webshop.webspeed.user.User;
import de.hsba.bi.webshop.webspeed.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class TestProductCreator {

    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final SaleRepository saleRepository;


    @EventListener(ApplicationStartedEvent.class)
    public void init() {
        User testUser1 = userRepository.save(new User("Jakob","TestUser1","$2a$12$k20SYS5padgkkHZnvAOwK.PFP4ZgrbzvwHLRF76o3QXykr55MyNWO"));
        User testUser2 = userRepository.save(new User("Niklas","TestUser2","$2a$12$k20SYS5padgkkHZnvAOwK.PFP4ZgrbzvwHLRF76o3QXykr55MyNWO"));

        Product testprodukt1 = productRepository.save(new Product("iPhone", new BigDecimal(1000), "altes iPhone", "elektronik", "unterdurchschnittlich", new Double(1), new Double(12), testUser1));
        Product testprodukt2 = productRepository.save(new Product("Laptop", new BigDecimal(300), "neuer Laptop", "elektronik", "sehr gut", new Double(1), new Double(0), testUser1));
        Product testprodukt3 = productRepository.save(new Product("Golf Cabrio", new BigDecimal(10000), "Neuwagen, 100k Kilometer", "autos", "unterdurchschnittlich", new Double(6), new Double(5), testUser2));

        /*Product testprodukt4 = productRepository.save(new Product("Katze", new BigDecimal(1000), "graue Katze, stinkt ein wenig", "garten", "sehr gut", new Double(1), new Double(12), testUser1));
        Product testprodukt5 = productRepository.save(new Product("Hund", new BigDecimal(300), "schwarzer Hund", "mode", "unterdurchschnittlich", new Double(1), new Double(0), testUser1));
        Product testprodukt6 = productRepository.save(new Product("Golf Cabrio", new BigDecimal(10000), "Neuwagen, 100k Kilometer", "autos", "unterdurchschnittlich", new Double(6), new Double(5), testUser2));
        Product testprodukt7 = productRepository.save(new Product("Katze", new BigDecimal(1000), "graue Katze, stinkt ein wenig", "garten", "sehr gut", new Double(1), new Double(12), testUser1));
        Product testprodukt8 = productRepository.save(new Product("Hund", new BigDecimal(300), "schwarzer Hund", "mode", "unterdurchschnittlich", new Double(1), new Double(0), testUser1));
        Product testprodukt9 = productRepository.save(new Product("Golf Cabrio", new BigDecimal(10000), "Neuwagen, 100k Kilometer", "autos", "unterdurchschnittlich", new Double(6), new Double(5), testUser2));
        Product testprodukt10 = productRepository.save(new Product("Katze", new BigDecimal(1000), "graue Katze, stinkt ein wenig", "garten", "sehr gut", new Double(1), new Double(12), testUser1));
        Product testprodukt11 = productRepository.save(new Product("Hund", new BigDecimal(300), "schwarzer Hund", "mode", "unterdurchschnittlich", new Double(1), new Double(0), testUser1));
        Product testprodukt12 = productRepository.save(new Product("Golf Cabrio", new BigDecimal(10000), "Neuwagen, 100k Kilometer", "autos", "unterdurchschnittlich", new Double(6), new Double(5), testUser2));
        Product testprodukt13 = productRepository.save(new Product("Katze", new BigDecimal(1000), "graue Katze, stinkt ein wenig", "garten", "sehr gut", new Double(1), new Double(12), testUser1));
        Product testprodukt14 = productRepository.save(new Product("Hund", new BigDecimal(300), "schwarzer Hund", "mode", "unterdurchschnittlich", new Double(1), new Double(0), testUser1));
        Product testprodukt15 = productRepository.save(new Product("Golf Cabrio", new BigDecimal(10000), "Neuwagen, 100k Kilometer", "autos", "unterdurchschnittlich", new Double(6), new Double(5), testUser2));
        Product testprodukt16 = productRepository.save(new Product("Katze", new BigDecimal(1000), "graue Katze, stinkt ein wenig", "garten", "sehr gut", new Double(1), new Double(12), testUser1));
        Product testprodukt17 = productRepository.save(new Product("Hund", new BigDecimal(300), "schwarzer Hund", "mode", "unterdurchschnittlich", new Double(1), new Double(0), testUser1));
        Product testprodukt18 = productRepository.save(new Product("Golf Cabrio", new BigDecimal(10000), "Neuwagen, 100k Kilometer", "autos", "unterdurchschnittlich", new Double(6), new Double(5), testUser2));
        Product testprodukt19 = productRepository.save(new Product("Katze", new BigDecimal(1000), "graue Katze, stinkt ein wenig", "garten", "sehr gut", new Double(1), new Double(12), testUser1));
        Product testprodukt20 = productRepository.save(new Product("Hund", new BigDecimal(300), "schwarzer Hund", "mode", "unterdurchschnittlich", new Double(1), new Double(0), testUser1));
        Product testprodukt21 = productRepository.save(new Product("Golf Cabrio", new BigDecimal(10000), "Neuwagen, 100k Kilometer", "autos", "unterdurchschnittlich", new Double(6), new Double(5), testUser2));
        Product testprodukt22 = productRepository.save(new Product("Katze", new BigDecimal(1000), "graue Katze, stinkt ein wenig", "garten", "sehr gut", new Double(1), new Double(12), testUser1));
        Product testprodukt23 = productRepository.save(new Product("Hund", new BigDecimal(300), "schwarzer Hund", "mode", "unterdurchschnittlich", new Double(1), new Double(0), testUser1));
        Product testprodukt24 = productRepository.save(new Product("Golf Cabrio", new BigDecimal(10000), "Neuwagen, 100k Kilometer", "autos", "unterdurchschnittlich", new Double(6), new Double(5), testUser2));
*/

        Sale testSale1 = saleRepository.save(new Sale(testUser2, testprodukt1, 12L));
        Sale testSale2 = saleRepository.save(new Sale(testUser1, testprodukt3, 5L));
    }
}
