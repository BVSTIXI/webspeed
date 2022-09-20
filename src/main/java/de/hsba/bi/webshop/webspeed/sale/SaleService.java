package de.hsba.bi.webshop.webspeed.sale;

import de.hsba.bi.webshop.webspeed.product.ProductService;
import de.hsba.bi.webshop.webspeed.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class SaleService {

    private final SaleRepository saleRepository;
    private final ProductService productService;
    private final UserService userService;

    //TODO numberSold erhöhen
    public void saveSale(Sale sale) {

        if (sale.soldProduct.getNumberAvailable() - sale.getNumberBought() >= 0) {
            sale.soldProduct.setNumberAvailable(sale.soldProduct.getNumberAvailable() - sale.getNumberBought());

            saleRepository.save(sale);
        }
    }

    public List<Sale> findMySales() {
        Long sellerSearch = userService.findCurrentUser().getUserId();
        return saleRepository.findBySoldProductsUserId(sellerSearch);
    }

    public List<Sale> findMyBoughtProducts() {
        Long buyerSearch = userService.findCurrentUser().getUserId();
        return saleRepository.findByBuyerUserId(buyerSearch);
    }
}

