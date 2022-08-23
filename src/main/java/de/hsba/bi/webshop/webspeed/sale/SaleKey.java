package de.hsba.bi.webshop.webspeed.sale;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class SaleKey implements Serializable {

    @Column(name = "USER_ID")
    Long userId;

    @Column(name = "PRODUCT_ID")
    Long productId;
}
