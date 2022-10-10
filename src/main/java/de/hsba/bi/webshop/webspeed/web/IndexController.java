package de.hsba.bi.webshop.webspeed.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//Diese Klasse mappt die index.html zur /allproducts url
@Controller
@RequestMapping("/")
public class IndexController {


    @GetMapping
    public String index(){
            return "redirect:/allproducts/";
        }
}
