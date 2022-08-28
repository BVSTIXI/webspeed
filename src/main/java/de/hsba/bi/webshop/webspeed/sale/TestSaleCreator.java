package de.hsba.bi.webshop.webspeed.sale;


import de.hsba.bi.webshop.webspeed.user.SaleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class TestSaleCreator {

    private final SaleRepository saleRepository;

    @EventListener(ApplicationStartedEvent.class)
    public void init() {
        //Sale Testsale = saleRepository.save(new Sale(1, 1, 0, false));
    }
}
