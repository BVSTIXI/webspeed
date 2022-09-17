package de.hsba.bi.webshop.webspeed.error;


import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError() {
        return "<h1>Something went wrong!</h1>";
    }

}