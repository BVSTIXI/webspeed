package de.hsba.bi.webshop.webspeed.product;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@NoArgsConstructor
public class Product implements Comparable<Product> {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Getter
    @Setter
    @Column(name = "PRODUCT_NAME", nullable = false, unique = false)
    private String name;

    @Getter
    @Setter
    @Column(name = "PRODUCT_PRICE", nullable = false, unique = false)
    private BigDecimal price;

    @Getter
    @Setter
    @Column(name = "PRODUCT_DESCRIPTION", nullable = true, unique = false)
    private String description;

    @Getter
    @Setter
    @Column(name = "PRODUCT_CATEGORY", nullable = true, unique = false)
    private String category;

    @Getter
    @Setter
    @Column(name = "PRODUCT_CONDITION", nullable = true, unique = false)
    private String condition;

    @Getter
    @Setter
    @Column(name = "PRODUCT_AVAILABLE", nullable = true, unique = false)
    private Double numberAvailable;

    @Getter
    @Setter
    @Column(name = "PRODUCT_SOLD", nullable = true, unique = false)
    private Double numberSold;

    /*
    @Getter
    @Setter
    private String seller;

    @Getter
    @Setter
    private String buyer;

    @Getter
    @Setter
    private boolean sold;

    @Getter
    @Setter
    private boolean shipped;

    @Getter
    @Setter
    private boolean sale;
    */
    public Product(String name, BigDecimal price){
        this.name = name;
        this.price = price;
    }

    @Override
    public int compareTo(Product other) {
        return this.name.compareTo(other.name);
    }
    @Override
    public String toString() {
        return name;
    }
}
