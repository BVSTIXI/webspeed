package de.hsba.bi.webshop.webspeed.product;

import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ProductRepository {

    private Map<Long, Product> store = new TreeMap<>();
    private AtomicLong sequence = new AtomicLong();

    Product save(Product product) {
        Long id = sequence.incrementAndGet();
        product.setId(id);
        store.put(id, product);
        return product;
    }
    Optional<Product>findbyId(Long id){
        return Optional.ofNullable(store.get(id));
    }
    Collection<Product> findAll() {
        return store.values();
    }
}
