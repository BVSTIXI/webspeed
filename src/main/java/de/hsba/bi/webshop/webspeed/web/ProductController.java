package de.hsba.bi.webshop.webspeed.web;


import de.hsba.bi.webshop.webspeed.product.ProductForm;
import de.hsba.bi.webshop.webspeed.product.ProductService;
import de.hsba.bi.webshop.webspeed.sale.Sale;
import de.hsba.bi.webshop.webspeed.sale.SaleService;
import de.hsba.bi.webshop.webspeed.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@Controller
@RequestMapping("/allproducts")
@RequiredArgsConstructor
public class ProductController {

    //Abhängigkeit deklarieren
    private final ProductService productService;
    private final UserService userService;
    private final SaleService saleService;

    //Abhängigkeit verwenden damit Controller keinen änderbaren Zustand hat
    //TODO Das ist wahrscheinlich ein Part von Basti; herausfinden, warum der bums mit dem Teil nicht funktioniert
    @GetMapping
    public String viewProducts(Model model, @Param("keyword") String keyword) {
        //List<Product> listProducts = productService.searchProduct(keyword);
        model.addAttribute("products", productService.searchProduct(keyword));
        model.addAttribute("keyword", keyword);
        return "/allproducts/index";
    }

    /*@GetMapping
    public String index(Model model) {
        model.addAttribute("products", productService.findAllProducts());
        return "allproducts/index";
    }*/

    @PostMapping()
    public String create(@RequestParam String name, @RequestParam BigDecimal price, @RequestParam String description, @RequestParam String category, @RequestParam String condition, @RequestParam Double numberAvailable) {
        productService.createProduct(name, price, description, category, condition, numberAvailable);
        return "redirect:/allproducts/myProducts";
    }

    @GetMapping(path="/{id}")
    public String show (@PathVariable("id") Long id, Model model) {
        if(productService.findProductById(id) == null); // throw new NotFoundException();
        model.addAttribute("product", productService.findProductById(id));
        //model.addAttribute("number", 0L);
        return "allproducts/productDetail";
    }

    @PostMapping(path = "/buy/{id}")
    public String buyProductController(@PathVariable("id") Long id, @RequestParam Long numberBought, Model model) {
        Sale mySale = new Sale(userService.findCurrentUser(), productService.findProductById(id), numberBought);
        saleService.saveSale(mySale);

        return "redirect:/";
    }

    @GetMapping(path="/createProduct{id}")
    public String showCreate (Model model) {
        model.addAttribute("productForm", new ProductForm());
        return "allproducts/createProduct";
    }


    /*@GetMapping(path = "productEdit/{id}")
    public String edit (@PathVariable("id") Long id, Model model) {
        model.addAttribute("productEdit", productService.getProduct(id));
        return "allproducts/productEdit";
    }*/

    @GetMapping(path="productEdit/{id}")
    public String edit (@PathVariable("id") Long id, Model model) {
        if (productService.findProductById(id) == null); // throw new NotFoundException();
        model.addAttribute("products", productService.findProductById(id));
        return "allproducts/productEdit";
    }


}
