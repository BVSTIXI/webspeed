package de.hsba.bi.webshop.webspeed.sale;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

//Diese Klasse stellt die Datenbankanbindung für die Sale-Objekte dar
public interface SaleRepository extends JpaRepository<Sale, Long> {

    //Diese Query gibt eine Liste aller Sale-Objekte, die vom User mit dem eingegebenen Usernamen verkauft wurden, wieder
    @Query("select s from Sale s where s.soldProduct.seller.userId = :sellerSearch")
    List<Sale> findBySoldProductsUserId(@Param("sellerSearch") Long sellerSearch);

    //Diese Query gibt eine Liste aller Sale-Objekte, die vom User mit dem eingegebenen Usernamen gekauft wurden, wieder
    @Query("select s from Sale s where s.buyer.userId = :buyerSearch")
    List<Sale> findByBuyerUserId(@Param("buyerSearch") Long buyerSearch);
}
