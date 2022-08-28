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
public class TestProductCreator {

    private final ProductRepository productRepository;

    @EventListener(ApplicationStartedEvent.class)
    public void init() {
        Product Testprodukt = productRepository.save(new Product("Katze", new BigDecimal(1000), "graue Katze, stinkt ein wenig", "Haustiere", "gut", new Double(1), new Double(0)));
    }
}
