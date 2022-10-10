package de.hsba.bi.webshop.webspeed.user;

import org.springframework.data.jpa.repository.JpaRepository;

//Diese Klasse stellt die Datenbankanbindung für die Userobjekte dar
public interface UserRepository extends JpaRepository<User, Long> {

    //Diese Funktion gibt den User wieder, dessen Username im Parameter steht
    User findByUserName (String userName);
}
