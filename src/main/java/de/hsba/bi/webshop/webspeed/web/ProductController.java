package de.hsba.bi.webshop.webspeed.web;

import de.hsba.bi.webshop.webspeed.error.NotFoundException;
import de.hsba.bi.webshop.webspeed.product.Product;
import de.hsba.bi.webshop.webspeed.product.ProductForm;
import de.hsba.bi.webshop.webspeed.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
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
    public String create(String name, BigDecimal price, String description, String category, String condition) {
        Product product = productService.createProduct(name, price, description, category, condition);
        return "redirect:/allproducts/";
    }

    @GetMapping(path="/{id}")
    public String show (@PathVariable("id") Long id, Model model) {
        if(productService.findProductById(id) == null) throw new NotFoundException();
        model.addAttribute("products", productService.findProductById(id));
        return "allproducts/productDetail";
    }
    @GetMapping(path="/createProduct{id}")
    public String showCreate ( Model model) {
        model.addAttribute("productForm", new ProductForm());
        return "allproducts/createProduct";
    }

    @GetMapping(path = "/myProducts")
    public String showMyProducts(Model model) {
        model.addAttribute("myProducts", productService.findMyProducts());
        return "allproducts/myProducts";
    }

    /*@GetMapping(path = "productEdit/{id}")
    public String edit (@PathVariable("id") Long id, Model model) {
        model.addAttribute("productEdit", productService.getProduct(id));
        return "allproducts/productEdit";
    }*/

    @GetMapping(path="productEdit/{id}")
    public String edit (@PathVariable("id") Long id, Model model) {
        if (productService.findProductById(id) == null) throw new NotFoundException();
        model.addAttribute("products", productService.findProductById(id));
        return "allproducts/productEdit";
    }
}
