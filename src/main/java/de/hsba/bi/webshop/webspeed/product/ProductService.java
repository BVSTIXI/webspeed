package de.hsba.bi.webshop.webspeed.product;

import de.hsba.bi.webshop.webspeed.user.UserRepository;
import de.hsba.bi.webshop.webspeed.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final UserService userService;

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }
    public Product createProduct(String name, BigDecimal price, String description, String category, String condition ) {
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
product.setDescription(description);
product.setCategory(category);
product.setCondition(condition);




        return productRepository.save(product);
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public Product getProduct(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public List<Product> findMyProducts() {
        Long search = userService.findCurrentUser().getUserId();
        return productRepository.findBySellerUserId(search);
    }
    public Product findProductById(Long id){
        if(productRepository.findById(id).isPresent()) return productRepository.findById(id).get();
        else return null;
    }

    public List<Product> searchProduct (String keyword) {
        return keyword == null ? productRepository.findAll() : productRepository.findByID(keyword.trim());
    }
}