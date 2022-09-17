package de.hsba.bi.webshop.webspeed.web;

import de.hsba.bi.webshop.webspeed.product.Product;
import de.hsba.bi.webshop.webspeed.product.ProductService;
import de.hsba.bi.webshop.webspeed.sale.Sale;
import de.hsba.bi.webshop.webspeed.sale.SaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class SaleController {

    private final SaleService saleService;
    private final ProductService productService;

    @PostMapping(path = "/allproducts/")
    public String buyProductController(Model model, @RequestParam Long productId, @RequestParam Long numberBought) {
        //saleService.buyProduct(product, numberBought);
        Product product = productService.findProductById(productId);
        model.addAttribute("sale", saleService.buyProduct(product, numberBought));
        return "redirect:/allproducts/";
    }
}
