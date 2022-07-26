package de.hsba.bi.webshop.webspeed.product;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class ProductEntry {

    private Product product;
    private Long id;
    private String name;
    private BigDecimal price;
    private String description;
    private String seller;
    private String buyer;
    private String category;
    private String condition;
    private Double numberAvailable;
    private Double numberSold;
    private boolean sold;
    private boolean shipped;
    private boolean sale;

    public ProductEntry(Long id, String name, BigDecimal price, String description, String seller, String buyer, String category,
                        String condition, Double numberAvailable, Double numberSold, boolean sold,
                        boolean shipped, boolean sale) {
        this.name = name;
        this.id = id;
        this.price = price;
        this.description = description;
        this.seller = seller;
        this.buyer = buyer;
        this.category = category;
        this.condition = condition;
        this.numberAvailable = numberAvailable;
        this.numberSold = numberSold;
        this.sold = sold;
        this.shipped = shipped;
        this.sale = sale;
    }
}
