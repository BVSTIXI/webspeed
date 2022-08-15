package de.hsba.bi.webshop.webspeed.user;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

public class User implements Comparable<User>{

    @Getter
    private Long id;

    @Getter
    @Setter
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
