package de.hsba.bi.webshop.webspeed.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
    public class IndexController {

        @GetMapping
        public String index(){
            return "redirect:/allproducts/";
        }

}
