package de.hsba.bi.webshop.webspeed.product;

import de.hsba.bi.webshop.webspeed.user.User;
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
    @Column(name = "PRODUCT_ID")
    private Long productId;

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

    @ManyToOne
    @Getter
    private User seller;

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
    private boolean de.hsba.bi.webshop.webspeed.sale;
    */
    public Product(String name, BigDecimal price, String description, String category, String condition, Double numberAvailable, Double numberSold, User seller){
        this.name = name;
        this.price = price;
        this.description = description;
        this.category = category;
        this.condition = condition;
        this.numberAvailable = numberAvailable;
        this.numberSold = numberSold;
        this.seller = seller;

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
