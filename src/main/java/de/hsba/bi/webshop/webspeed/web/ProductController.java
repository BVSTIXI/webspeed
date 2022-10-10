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

//Diese Klasse verbindet die Logikklassen mit dem Frontend der allproducts, myProducts, productDetail, createProduct und productEdit Seiten
@Controller
@RequestMapping("/allproducts")
@RequiredArgsConstructor
public class ProductController {

    //Abhängigkeit deklarieren
    private final ProductService productService;
    private final UserService userService;
    private final SaleService saleService;

    //Diese Funktion mappt die searchProducts() Funktion zur allproducts Seite, sodass auf dieser Seite nach Produkten gesucht werden kann
    @GetMapping
    public String viewProducts(Model model, @Param("keyword") String keyword, @Param("checkValue") Boolean checkValue) {
        //List<Product> listProducts = productService.searchProduct(keyword);
        model.addAttribute("products", productService.searchProduct(keyword, checkValue));
        model.addAttribute("keyword", keyword);
        model.addAttribute("checkValue", checkValue);
        return "/allproducts/index";
    }

    //Diese Funktion mappt die createProduct() Funktion zur createproduct Seite und leitet den Nutzer nach dem erstellen eines Produktes auf die myProducts Seite weiter
    @PostMapping()
    public String create(@RequestParam String name, @RequestParam BigDecimal price, @RequestParam String description, @RequestParam String category, @RequestParam String condition, @RequestParam Double numberAvailable) {
        productService.createProduct(name, price, description, category, condition, numberAvailable);
        return "redirect:/user/myProducts";
    }

    //Diese Funktion mappt die findProductById() Funktion zur productDetail Seite, damit die Details des richtigen Produktes angezeigt werden können
    @GetMapping(path="/{id}")
    public String show (@PathVariable("id") Long id, Model model) {
        if(productService.findProductById(id) == null); // throw new NotFoundException();
        model.addAttribute("product", productService.findProductById(id));
        return "allproducts/productDetail";
    }

    //Diese Funktion mappt die findCurrentUser(), findProductById() und saveSale() Funktionen zur buy-Seite, damit beim klicken auf den kauf-Button auf der productDetail-Seite ein Sale-Objekt mit den richtigen User- und Produkt-Attributen erstellt werden kann
    @PostMapping(path = "/buy/{id}")
    public String buyProductController(@PathVariable("id") Long id, @RequestParam Long numberBought, Model model) {
        Sale mySale = new Sale(userService.findCurrentUser(), productService.findProductById(id), numberBought);
        saleService.saveSale(mySale);

        return "redirect:/user/myBoughtProducts";
    }

    //Diese Funktion mappt ein Form zum eingeben der Attribute zur createProduct Seite
    @GetMapping(path="/createProduct{id}")
    public String showCreate (Model model) {
        model.addAttribute("productForm", new ProductForm());
        return "allproducts/createProduct";
    }

    //Diese Funktion mappt die findProductById() Funktion zur productEdit-Seite, damit das richtige Produkt-Objekt angezeigt und editiert wird
    @GetMapping(path = "/productEdit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        if (productService.findProductById(id) == null) ; // throw new NotFoundException();
        model.addAttribute("products", productService.findProductById(id));
        return "allproducts/productEdit";
    }

    //Diese Funktion mappt die editProduct() Funktion zur productEdit Seite
    @PostMapping(path = "/productEdit/{id}")
    public String editProduct(@PathVariable("id") Long id, @RequestParam String name, @RequestParam BigDecimal price, @RequestParam String description, @RequestParam String category, @RequestParam String condition, @RequestParam Double numberAvailable) {
        productService.editProduct(id, name, price, description, category, condition, numberAvailable);
        return "redirect:/";
    }
}
