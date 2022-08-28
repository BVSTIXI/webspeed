package de.hsba.bi.webshop.webspeed.user;

import de.hsba.bi.webshop.webspeed.sale.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale, Long> {

}