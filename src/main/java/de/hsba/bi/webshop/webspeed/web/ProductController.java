package de.hsba.bi.webshop.webspeed.web;

import de.hsba.bi.webshop.webspeed.product.Product;
import de.hsba.bi.webshop.webspeed.product.ProductForm;
import de.hsba.bi.webshop.webspeed.product.ProductService;
import de.hsba.bi.webshop.webspeed.user.User;
import de.hsba.bi.webshop.webspeed.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
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

    //Abhängigkeit verwenden damit Controller keinen änderbaren Zustand hat
    @GetMapping
    public String index(Model model) {
        model.addAttribute("products", productService.findAllProducts());
        return "allproducts/index";
    }

   /* @PostMapping
    public String create(String name, BigDecimal price) {
        Product product = productService.createProduct(name, price);
        return "redirect:/allproducts/";
    }*/

    @GetMapping(path="/{id}")
    public String show (@PathVariable("id") Long id, Model model) {
        model.addAttribute("products", productService.findAllProducts());
        return "allproducts/productDetail";
    }

    @GetMapping(path= "/createProduct")
    public String createProduct (Model model) {
        model.addAttribute("productForm", new ProductForm() );
        return "allproducts/productcreate";
    }
 //   @PostMapping(path ="/createProduct")
  //  public String createProduct(@ModelAttribute ProductForm productForm) {
        //Im GetMapping haben wir eine Klasse namens ProductForm gegeben, innerhalb vom html haben wir in die Attribute von diesem Objekt gfeschrieben
        // Thymeleaf Post abfangen
        //Infos aus dem productForm Objkekt müssen innehralb eines form Converters, also einer normalen Funktion, zu Product Objekten umgewandelt werden.
        //Dabei müssen die Informationen wie owner hinzugefügt werden.

    //    Product newProduct = new Product(productForm.getName(),productForm.getPrice(), productForm.getCategory(), productForm.getDescription(), productForm.getCondition() );

     //   System.out.println(newProduct);

    //    return "redirect: /";
   // }
}
