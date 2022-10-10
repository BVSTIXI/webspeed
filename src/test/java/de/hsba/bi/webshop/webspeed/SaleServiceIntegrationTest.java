package de.hsba.bi.webshop.webspeed;

import de.hsba.bi.webshop.webspeed.product.Product;
import de.hsba.bi.webshop.webspeed.sale.Sale;
import de.hsba.bi.webshop.webspeed.sale.SaleRepository;
import de.hsba.bi.webshop.webspeed.sale.SaleService;
import de.hsba.bi.webshop.webspeed.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.math.BigDecimal;

@SpringBootTest
@Transactional
public class SaleServiceIntegrationTest {

    @Autowired
    private SaleService saleServiceToTest;

    EntityManager entityManager;
    SaleRepository saleRepository;



    @BeforeEach
    void setUp() {
        //saleRepository.deleteAll();
    }

    @Test
    public void saveSale() {
        User testUser10 = new User("Test","TestUser0","$2a$12$k20SYS5padgkkHZnvAOwK.PFP4ZgrbzvwHLRF76o3QXykr55MyNWO");
        User testUser20 = new User("Test1", "TestUser1", "$2a$12$k20SYS5padgkkHZnvAOwK.PFP4ZgrbzvwHLRF76o3QXykr55MyNWO");
        Product testProduct = new Product("iPhone", new BigDecimal(1000), "altes iPhone", "elektronik", "unterdurchschnittlich", new Double(1), new Double(12), testUser10);

        Sale sale = new Sale(testUser20, testProduct, 10L);
        if (sale.getSoldProduct().getNumberAvailable() - sale.getNumberBought() >= 0 && !(sale.getSoldProduct().getSeller() == sale.getBuyer())) {
            sale.getSoldProduct().setNumberAvailable(sale.getSoldProduct().getNumberAvailable() - sale.getNumberBought());
            sale.getSoldProduct().setNumberSold(sale.getSoldProduct().getNumberSold() + sale.getNumberBought());

            saleRepository.save(sale);
        }
    }
}
