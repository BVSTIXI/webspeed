package de.hsba.bi.webshop.webspeed.user;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User implements Comparable<User>{

    public static String USER_ROLE = "USER";
    public static String ADMIN_ROLE = "ADMIN";

    // public static String getCurrentUsername() {
        // Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        // if (principal instanceof UserDetails) {
            // return ((UserDetails) principal).getUsername();
        // }
        // return null;
    // }

    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue
    private Long id;

    @Basic(optional = false)
    private String name;

    @Basic(optional = false)
    private String password;

    private String role;

    public User(String name){
        this.name = name;
    }

    public User(String name, String password, String role) {
        this.password = password;
        this.role = role;
        this.name = name;
    }

    @Override
    public int compareTo(User diffuser) {
        return this.name.compareTo(diffuser.name);
    }

    @Override
    public String toString() {
        return name;
    }

}
