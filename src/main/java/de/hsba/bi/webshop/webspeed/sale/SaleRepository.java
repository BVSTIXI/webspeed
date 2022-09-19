package de.hsba.bi.webshop.webspeed.user;

import de.hsba.bi.webshop.webspeed.sale.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, Long> {

    @Query("select s from Sale s where s.soldProduct.seller.userId = :sellerSearch")
    List<Sale> findBySoldProductsUserId(@Param("sellerSearch") Long sellerSearch);

    @Query("select s from Sale s where s.buyer.userId = :buyerSearch")
    List<Sale> findByBuyerUserId(@Param("buyerSearch") Long buyerSearch);
}
