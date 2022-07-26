package de.hsba.bi.webshop.webspeed.product;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

@Service
@Transactional
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Product createProduct(String name) {
        Product product = new Product();
        product.setName(name);
        return repository.save(product);
    }

    public Product save(Product product) {
        return repository.save(product);
    }

    public Product getProduct(Long id) {
        return repository.findbyId(id).orElse(null);
    }

    public void addProductEntry(Product product, ProductEntry entry) {
        entry.setProduct(product);
        product.getEntries().add(entry);
    }

    public Collection<Product> getAll() {
        return repository.findAll();
    }
}
