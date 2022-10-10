package de.hsba.bi.webshop.webspeed;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
/*TODO productEdit nur für angemeldete Nutzer zugänglich machen*/
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/").permitAll()
                .antMatchers(HttpMethod.GET, "/user/myProducts","/user/mySales", "/user/myBoughtProducts", "/allproducts/createProduct", "/allproducts/productEdit/*", "/user/sendConfirm/*","/user/deleteProduct/*").authenticated()
                .antMatchers(HttpMethod.GET, "/allproducts/*","/user/").permitAll()
                .anyRequest().permitAll()
                .and()
            .formLogin()
                .permitAll()
                .and()
            .logout()
                .logoutSuccessUrl("/allproducts/")
                .permitAll();
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/h2-console/**");
    }

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}