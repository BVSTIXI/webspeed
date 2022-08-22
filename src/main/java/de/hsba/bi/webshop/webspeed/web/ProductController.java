package de.hsba.bi.webshop.webspeed.web;

import de.hsba.bi.webshop.webspeed.product.Product;
import de.hsba.bi.webshop.webspeed.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;

@Controller
@RequestMapping("/allproducts")
@RequiredArgsConstructor
public class ProductController {

    //Abhängigkeit deklarieren
    private final ProductService productService;

    //Abhängigkeit verwenden damit Controller keinen änderbaren Zustand hat
    @GetMapping
    public String index(Model model) {
        model.addAttribute("products", productService.findAllProducts());
        return "allproducts/index";
    }

    @PostMapping
    public String create(String name, BigDecimal price) {
        Product product = productService.createProduct(name, price);
        return "redirect:/allproducts/";
    }

    @GetMapping(path="/{id}")
    public String show (@PathVariable("id") Long id, Model model) {
        model.addAttribute("products", productService.findAllProducts());
        return "allproducts/productDetail";
    }
}
