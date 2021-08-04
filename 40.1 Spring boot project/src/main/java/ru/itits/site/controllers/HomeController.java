package ru.itits.site.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.itits.site.models.Product;
import ru.itits.site.service.ProductService;

import java.util.Optional;

@Controller
public class HomeController {

    private final ProductService productService;

    @Autowired
    public HomeController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping( "/shop")
    public String shop(Model model) {
        model.addAttribute("allProducts", productService.getAll());
        return "shop";
    }

    @GetMapping("/shop/viewproduct/{id}")
    public String viewProduct(Model model, @PathVariable Long id) {
        Optional<Product> oneProduct = productService.findById(id);
        model.addAttribute("id", oneProduct.get().getId());
        model.addAttribute("name", oneProduct.get().getName());
        model.addAttribute("price", oneProduct.get().getPrice());
        return "viewProduct";
    }
}
