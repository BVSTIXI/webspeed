package de.hsba.bi.webshop.webspeed.web.user;

import de.hsba.bi.webshop.webspeed.product.ProductService;
import de.hsba.bi.webshop.webspeed.sale.SaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//Diese Klasse verbindet die Logikklassen mit dem Frontend der myProducts, mySales und myBoughtProducts-Seiten
@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class MyItemsController {

    //Abhängigkeiten
    private final ProductService productService;
    private final SaleService saleService;

    //Diese Funktion mappt die findMyProducts() Funktion zur myProdukts Seite
    @GetMapping(path = "/myProducts")
    public String showMyProducts(Model model) {
        model.addAttribute("myProducts", productService.findMyProducts());
        return "user/myProducts";
    }

    //Diese Funktion mappt die findMySales() Funktion zur mySales Seite
    @GetMapping(path = "/mySales")
    public String showMySales(Model model) {
        model.addAttribute("mySales", saleService.findMySales());
        return "user/mySales";
    }

    //Diese Funktion mappt die myBoughtProducts() Funktion zur myBoughtProducts Seite
    @GetMapping(path = "/myBoughtProducts")
    public String showMyBoughtProducts(Model model) {
        model.addAttribute("myBoughtProducts", saleService.findMyBoughtProducts());
        return "user/myBoughtProducts";
    }

    //Diese Funktion mappt die findSaleById() Funktion zur sendConfirm Seite
    @GetMapping(path = "/sendConfirm/{id}")
    public String showConfirm(@PathVariable("id") Long id, Model model) {
        if (productService.findProductById(id) == null);
        model.addAttribute("mySale", saleService.findSaleById(id));
        return "user/sendConfirm";
    }

    //Diese Funktion mappt eine PostRequest auf der sendConfirm Seite, über die die ProduktId an die sendProduct() Funktion übergeben
    @PostMapping(path = "/sendConfirm/{id}")
    public String send(@PathVariable("id") Long id) {
        saleService.sendProduct(id);
        return "redirect:/user/mySales";
    }

    @GetMapping(path = "/deleteProduct/{id}")
    public String delete(@PathVariable("id") Long id, Model model) {
        if (productService.findProductById(id) == null);
        model.addAttribute("products", productService.findProductById(id));
        return "user/deleteProduct";
    }

    @PostMapping(path = "/deleteProduct/{id}")
    public String deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
        return "redirect:/user/myProducts";
    }
}