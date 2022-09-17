package de.hsba.bi.webshop.webspeed.sale;

import de.hsba.bi.webshop.webspeed.product.Product;
import de.hsba.bi.webshop.webspeed.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Table(name = "SALE")
public class Sale {

//    @EmbeddedId
//    SaleKey id;
//
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "SALE_ID")
    private Long saleId;

    @ManyToOne
    //@MapsId("buyerId")
    @Getter
    @JoinColumn(name = "BUYER_ID")
    User buyer;

    @ManyToOne
    //@MapsId("soldProductId")
    @Getter
    @JoinColumn(name = "SOLDPRODUCT_ID")
    Product soldProduct;

    @Getter
    @Setter
    @Column(name = "NUMBER_BOUGHT", nullable = false, unique = false)
    private Long numberBought;

    @Getter
    @Setter
    @Column(name = "ORDER_STATUS", nullable = false, unique = false)
    private boolean status;

    public Sale (User buyer, Product product, Long numberBought, boolean status) {
        this.buyer = buyer;
        this.soldProduct = product;
        this.numberBought = numberBought;
        this.status = status;
    }

}
