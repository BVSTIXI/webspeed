package de.hsba.bi.webshop.webspeed.product;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.function.IntToLongFunction;
import java.util.function.LongToIntFunction;

@Component
@RequiredArgsConstructor
public class TestDataCreator {

    private final ProductRepository productRepository;

    @EventListener(ApplicationStartedEvent.class)
    public void init() {
        Product product = new Product();
        product.setName("Kuchen");
        product.getEntries().add(new ProductEntry(1L,"Kuchen",new Double(9.99),"Lecker Kuchen","Jakob","Aylin",
                "Lebensmittel", "Sehr gut",1.00,0.00,false, false, false));
        productRepository.save(product);
        Product product2 = new Product();
        product2.setName("Katze");
        product2.getEntries().add(new ProductEntry(2L,"Katze",new Double(24.99),"Gatze","Basti","",
                "Haustier", "Sehr gut",1.00,0.00,false, false, false));
        productRepository.save(product2);
    }
}
