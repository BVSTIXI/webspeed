package de.hsba.bi.webshop.webspeed.product;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

public class ProductForm {
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
    private String condition;
    @Getter
    @Setter
    private String category;
}
