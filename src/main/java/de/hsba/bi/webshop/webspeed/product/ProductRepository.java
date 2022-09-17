package de.hsba.bi.webshop.webspeed.product;

import de.hsba.bi.webshop.webspeed.user.User;
import de.hsba.bi.webshop.webspeed.user.UserService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

interface ProductRepository extends JpaRepository<Product,Long> {

    @Query("select p from Product p where p.seller.userId = :search")  //
    List<Product> findBySellerUserId(@Param("search") Long search); //

    @Query("select p from Product p join Sale s on p.productId = s.saleId where p.seller.userId = 1")
    List<Product> findByProductIdAndSellerUserId();
    @Query("select s from Sale s where s.buyer.userId = 1")
    List<Product> findByBuyerUserId();

    @Query("select p from Product p where p.name like %:keyword%")
    List<Product> findByName(@Param("keyword") String keyword);
}
