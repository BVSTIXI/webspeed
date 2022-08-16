package de.hsba.bi.webshop.webspeed.product;

import lombok.Getter;
import lombok.Setter;
import user.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Getter
    @Setter
    @Column(name = "PRODUCT_NAME", nullable = false, unique = false)
    private String name;

    @Getter
    @Setter
    @Column(name = "PRODUCT_PRICE", nullable = false, unique = false)
    private Double price;

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
    private boolean sale;
    */

    private List<ProductEntry> entries;

    public List<ProductEntry> getEntries() {
        if (entries == null) {
            entries = new ArrayList<>();
        }
        return entries;
    }
}
