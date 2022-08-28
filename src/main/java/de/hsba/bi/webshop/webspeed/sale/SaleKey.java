package de.hsba.bi.webshop.webspeed.sale;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class SaleKey implements Serializable {

    @Column(name = "BUYER_ID")
    Long buyerId;

    @Column(name = "SOLDPRODUCT_ID")
    Long soldProductId;
}
