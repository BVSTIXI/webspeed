package de.hsba.bi.webshop.webspeed.sale;

import de.hsba.bi.webshop.webspeed.product.Product;
import de.hsba.bi.webshop.webspeed.user.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "SALE")
public class Sale {

    @EmbeddedId
    SaleKey id;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "USER_ID")
    User buyer;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "PRODUCT_ID")
    Product product;

    @Getter
    @Setter
    @Column(name = "NUMBER_BOUGHT", nullable = false, unique = false)
    private int numberBought;

    @Getter
    @Setter
    @Column(name = "ORDER_STATUS", nullable = false, unique = false)
    private boolean status;



}
