package de.hsba.bi.webshop.webspeed.product;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Product {

    @Getter
    @Setter
    private Long id;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private BigDecimal price;
    @Getter
    @Setter
    private String description;
    @Getter
    @Setter
    private String seller;
    @Getter
    @Setter
    private String buyer;
    @Getter
    @Setter
    private String category;
    @Getter
    @Setter
    private String condition;
    @Getter
    @Setter
    private Double numberAvailable;
    @Getter
    @Setter
    private Double numberSold;
    @Getter
    @Setter
    private boolean sold;
    @Getter
    @Setter
    private boolean shipped;
    @Getter
    @Setter
    private boolean sale;

    private List<ProductEntry> entries;

    public List<ProductEntry> getEntries() {
        if (entries == null) {
            entries = new ArrayList<>();
        }
        return entries;
    }
}
