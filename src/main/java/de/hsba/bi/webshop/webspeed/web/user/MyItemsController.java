package de.hsba.bi.webshop.webspeed.web.user;

import de.hsba.bi.webshop.webspeed.product.ProductService;
import de.hsba.bi.webshop.webspeed.sale.SaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class MyItemsController {

    private final ProductService productService;
    private final SaleService saleService;

    @GetMapping(path = "/myProducts")
    public String showMyProducts(Model model) {
        model.addAttribute("myProducts", productService.findMyProducts());
        return "user/myProducts";
    }

    @GetMapping(path = "/mySales")
    public String showMySales(Model model) {
        model.addAttribute("mySales", saleService.findMySales());
        return "user/mySales";
    }

    @GetMapping(path = "/myBoughtProducts")
    public String showMyBoughtProducts(Model model) {
        model.addAttribute("myBoughtProducts", saleService.findMyBoughtProducts());
        return "user/myBoughtProducts";
    }
}