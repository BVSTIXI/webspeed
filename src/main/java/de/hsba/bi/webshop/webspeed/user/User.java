package de.hsba.bi.webshop.webspeed.user;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;

@Table(name="Users")
@Entity
@NoArgsConstructor
public class User implements Comparable<User> {

    public static String getCurrentUsername() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            return ((UserDetails) principal).getUsername();
        }
        return null;
    }


    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USER_ID")
    private Long userId;

    @Getter
    @Setter
    @Column(name = "NAME", nullable = false, unique = false)
    private String name;

    @Getter
    @Setter
    @Column(name = "USERNAME", nullable = false, unique = false)
    private String userName;

    @Getter
    @Setter
    @Column(name= "PASSWORD", nullable = false)
    private String password;

    /*@OneToMany(mappedBy = "seller")
    private List<Product> offeredProducts;*/


    public User(String name, String userName, String password){
        this.name = name;
        this.userName = userName;
        this.password = password;
    }
    @Override
    public int compareTo(User other) {
        return this.name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return name;
    }
}
