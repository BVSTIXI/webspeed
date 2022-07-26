package de.hsba.bi.webshop.webspeed.web;

import de.hsba.bi.webshop.webspeed.product.Product;
import de.hsba.bi.webshop.webspeed.product.ProductEntry;
import de.hsba.bi.webshop.webspeed.product.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/allproducts")
public class ProductController {

    //Abhängigkeit deklarieren
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //Abhängigkeit verwenden damit Controller keinen änderbaren Zustand hat
    @GetMapping
    public String index(Model model) {
        model.addAttribute("products", productService.getAll());
        return "allproducts/index";
    }

    @PostMapping
    public String create(String name) {
        Product product = productService.createProduct(name);
        return "redirect:/allproducts/" + product.getId();
    }

    @GetMapping(path = "/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        model.addAttribute("product", productService.getProduct(id));
        return "allproducts/products";
    }


    @PostMapping(path = "/{id}")
    public String addEntry(@PathVariable("id") Long id, ProductEntry entry) {
        Product product = productService.getProduct(id);
        productService.addProductEntry(product, entry);
        return "redirect:/allproducts/" + id;
    }
}
