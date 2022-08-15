package de.hsba.bi.webshop.webspeed.user;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
public class User implements Comparable<User>{

    @Getter
    @Id
    @GeneratedValue
    private Long id;

    @Getter
    @Setter
    @Basic(optional = false)
    private String name;

    public User(String name){
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
