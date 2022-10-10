package de.hsba.bi.webshop.webspeed.sale;

import de.hsba.bi.webshop.webspeed.product.ProductService;
import de.hsba.bi.webshop.webspeed.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

//Diese Klasse beinhaltet die Logikoperationen für Sale-Objekte
@Service
@Transactional
@RequiredArgsConstructor
public class SaleService {

    //Abhängigkeiten
    private final SaleRepository saleRepository;
    private final ProductService productService;
    private final UserService userService;

    //Diese Funktion speichert ein zuvor erstelltes Sale-Objekt in der Datenbank und passt die relevanten Attribute des betroffenen Produktes an.
    public void saveSale(Sale sale) {
            //Passt die verfügbare Anzahl des Produktes an.
            sale.soldProduct.setNumberAvailable(sale.soldProduct.getNumberAvailable() - sale.getNumberBought());
            //Passt die verkaufte Anzahl des Produktes an.
            sale.soldProduct.setNumberSold(sale.soldProduct.getNumberSold() + sale.getNumberBought());
            saleRepository.save(sale);
    }

    //Diese Funktion gibt alle Sale-Objekte wieder, die vom aktuellen User verkauft wurden.
    public List<Sale> findMySales() {
        Long sellerSearch = userService.findCurrentUser().getUserId();
        return saleRepository.findBySoldProductsUserId(sellerSearch);
    }

    // Diese Funktion gibt das Sale-Objekt aus, dessen ID dem Parameter entspricht.
    public Sale findSaleById(Long id) {
        if(saleRepository.findById(id).isPresent()) return saleRepository.findById(id).get();
        else return null;
    }

    //Diese Funktion gibt alle Sale-Objekte wieder, die vom aktuellen User gekauft wurden.
    public List<Sale> findMyBoughtProducts() {
        Long buyerSearch = userService.findCurrentUser().getUserId();
        return saleRepository.findByBuyerUserId(buyerSearch);
    }

    //Diese Funktion verändert den Versandstatus eines verkauften Produktes.
    public Sale sendProduct(Long saleId) {
        Sale saleToEdit = saleRepository.getOne(saleId);
        saleToEdit.setStatus(true);
        return saleRepository.save(saleToEdit);
    }
}

