package de.hsba.bi.webshop.webspeed.user;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;

//Diese Klasse stellt einen Nutzer dar, der sich anmelden und Produkte kaufen, verkaufen, bearbeiten und so weiter, kann
@Table(name="Users")
@Entity
@NoArgsConstructor
public class User implements Comparable<User> {

    //Diese Funktion gibt den Username des aktuell angemeldeten Users wieder. Falls aktuell kein User angemeldet ist, gibt sie null wieder
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

    //Der echte Name des Nutzers
    @Getter
    @Setter
    @Column(name = "NAME", nullable = false, unique = false)
    private String name;

    //Der Nutzername muss einzigartig sein
    @Getter
    @Setter
    @Column(name = "USERNAME", nullable = false, unique = true)
    private String userName;

    //Das Passwort mit dem sich der Nutzer anmeldet. Es wird bei der Registrierung im UserService verschlüsselt
    @Getter
    @Setter
    @Column(name= "PASSWORD", nullable = false)
    private String password;

    //Der Konstruktor
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