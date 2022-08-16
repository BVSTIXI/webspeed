package user;

import de.hsba.bi.webshop.webspeed.product.Product;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "USER")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Getter
    @Setter
    @Column(name="USER_NAME", nullable=false, unique=true)
    private String name;

    @Getter
    @Setter
    private String password;

    @OneToMany (mappedBy = "seller")
    private List<Product> sellingProducts;
}
