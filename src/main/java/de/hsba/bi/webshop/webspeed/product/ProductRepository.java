package de.hsba.bi.webshop.webspeed.product;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

//Diese Klasse stellt die Datenbankanbindung für die Produktobjekte dar
public interface ProductRepository extends JpaRepository<Product,Long> {

    //Diese Query gibt eine Liste mit allen Produkten wieder, die vom gesuchten User verkauft werden
    @Query("select p from Product p where p.seller.userId = :search")
    List<Product> findBySellerUserId(@Param("search") Long search);

    //Diese Query gibt eine Liste mit allen Produkten wieder, deren Name der Eingabe in der Suchleiste entspricht
    @Query("select p from Product p where lower(p.name) like %:keyword%")
    List<Product> findByName(@Param("keyword") String keyword);

    @Query("select i from Product i where i.numberAvailable > 0")
    List<Product> findByAvailability();

    @Query("select j from Product j where lower(j.name) like %:keyword% and j.numberAvailable > 0")
    List<Product> findByNameAndAvailability(@Param("keyword") String keyword);

}
