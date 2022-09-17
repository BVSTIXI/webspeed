package de.hsba.bi.webshop.webspeed.sale;

import de.hsba.bi.webshop.webspeed.product.Product;
import de.hsba.bi.webshop.webspeed.product.ProductService;
import de.hsba.bi.webshop.webspeed.user.SaleRepository;
import de.hsba.bi.webshop.webspeed.user.User;
import de.hsba.bi.webshop.webspeed.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class SaleService {

    private final SaleRepository saleRepository;
    private final ProductService productService;
    private final UserService userService;

    public Sale buyProduct(Product product, Long numberBought) {
        User buyer = userService.findCurrentUser();
        product.setNumberAvailable(product.getNumberAvailable() - numberBought);

        Sale sale = new Sale (buyer, product, numberBought, false);

        return saleRepository.save(sale);
    }
}
