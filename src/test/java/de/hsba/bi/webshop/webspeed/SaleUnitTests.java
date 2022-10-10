package de.hsba.bi.webshop.webspeed;

import de.hsba.bi.webshop.webspeed.product.Product;
import de.hsba.bi.webshop.webspeed.sale.Sale;
import de.hsba.bi.webshop.webspeed.sale.SaleRepository;
import de.hsba.bi.webshop.webspeed.sale.SaleService;
import de.hsba.bi.webshop.webspeed.user.User;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoSettings;

import java.math.BigDecimal;


@MockitoSettings
class SaleUnitTests {

    @Mock
    private SaleRepository saleRepositoryMock;

    @InjectMocks
    private SaleService saleServiceMock;
    /*Product testprodukt1 = productRepository.save(new Product("Katze", new BigDecimal(1000), "graue Katze, stinkt ein wenig", "garten", "sehr gut", new Double(1), new Double(12), testUser1));
    Product testprodukt2 = productRepository.save(new Product("Hund", new BigDecimal(300), "schwarzer Hund", "mode", "unterdurchschnittlich", new Double(1), new Double(0), testUser1));
    Product testprodukt3 = productRepository.save(new Product("Golf Cabrio", new BigDecimal(10000), "Neuwagen, 100k Kilometer", "autos", "unterdurchschnittlich", new Double(6), new Double(5), testUser2));
    */


    @Test
    public void buyProduct() {
        User user = new User("Jakob","TestUser1","$2a$12$k20SYS5padgkkHZnvAOwK.PFP4ZgrbzvwHLRF76o3QXykr55MyNWO");
        Product product = new Product("Katze", new BigDecimal(1000), "graue Katze, stinkt ein wenig", "garten", "sehr gut", new Double(1), new Double(12), user);
        Sale sale = new Sale(user, product, 12L);

        //mit getSoldProduct() wird das verkaufte Produkt nicht in der Datenbank upgedatet. Wir brauchen eine andere Lösung.
        if (sale.getSoldProduct().getNumberAvailable() - sale.getNumberBought() >= 0 && !(sale.getSoldProduct().getSeller() == sale.getBuyer())) {
            sale.getSoldProduct().setNumberAvailable(sale.getSoldProduct().getNumberAvailable() - sale.getNumberBought());
            sale.getSoldProduct().setNumberSold(sale.getSoldProduct().getNumberSold() + sale.getNumberBought());

            saleRepositoryMock.save(sale);
        }
    }
}
