package de.hsba.bi.webshop.webspeed.product;

import de.hsba.bi.webshop.webspeed.user.User;
import de.hsba.bi.webshop.webspeed.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

//Diese Klasse beinhaltet die Logikoperationen im Bezug auf Produktobjekte
@Service
@Transactional
@RequiredArgsConstructor
public class ProductService {

    //Einbindung der Abhängigkeiten
    private final ProductRepository productRepository;
    private final UserService userService;

    //Diese Funktion löscht ein Produktobjekt aus der Datenbank
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    //Diese Funktion gibt alle Produkte, die in der Datenbank gespeichert sind, wieder
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    //Diese Funktion erstellt ein Produktobjekt und speichert es in der Datenbank
    public Product createProduct(String name, BigDecimal price, String description, String category, String condition, Double numberAvailable ) {
        User seller = userService.findCurrentUser();
        Product product = new Product(name, price, description, numberAvailable, seller);
        //Dieses Attribut ist optional
        if (!category.isEmpty()) {
            product.setCategory(category);
        }
        //Dieses Attribut ist optional
        if (!condition.isEmpty()) {
            product.setCondition(condition);
        }

        return productRepository.save(product);
    }

    //Diese Funktion gibt alle Produkte aus, die vom aktuell eingeloggten User verkauft werden.
    public List<Product> findMyProducts() {
        Long search = userService.findCurrentUser().getUserId();
        return productRepository.findBySellerUserId(search);
    }

    //Diese Funktion gibt das Produkt aus, dessen ID dem Parameter entspricht.
    public Product findProductById(Long id){
        if(productRepository.findById(id).isPresent()) return productRepository.findById(id).get();
        else return null;
    }

    //Diese Funktion gibt alle Produkte aus der Datenbank aus, wenn die Eingabe leer ist. Ansonsten gibt sie alle Produkte mit dem passenden Namen aus.
    public List<Product> searchProduct (String keyword, Boolean checkValue) {
        if(keyword == null && checkValue == null) {
            return productRepository.findAll();
        } else if (keyword == null && checkValue != null) {
            return productRepository.findByAvailability();
        } else if (keyword != null && checkValue != null) {
            return productRepository.findByNameAndAvailability(keyword.trim().toLowerCase());
        } else {
            return productRepository.findByName(keyword.trim().toLowerCase());
        }
    }

    //Diese Funktion editiert ein vorhandenes Produkt.
    public Product editProduct(Long productId, String name, BigDecimal price, String description, String category, String condition, Double numberAvailable) {
        Product productToEdit = productRepository.getOne(productId);
        productToEdit.setName(name);
        productToEdit.setPrice(price);
        productToEdit.setDescription(description);
        productToEdit.setCategory(category);
        productToEdit.setCondition(condition);
        productToEdit.setNumberAvailable(numberAvailable);
        return productRepository.save(productToEdit);
    }
}