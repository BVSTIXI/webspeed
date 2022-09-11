package de.hsba.bi.webshop.webspeed.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

interface ProductRepository extends JpaRepository<Product,Long> {
    @Query("select p from Product p where p.seller.userId = 1")
    List<Product> findBySellerUserId();
    @Query("select p from Product p join Sale s on p.productId = s.saleId where p.seller.userId = 1")
    List<Product> findByProductIdAndSellerUserId();
    @Query("select s from Sale s where s.buyer.userId = 1")
    List<Product> findByBuyerUserId();
}
