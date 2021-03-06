package ru.itits.site.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.itits.site.service.AccountService;
import ru.itits.site.service.ProductService;
import ru.itits.site.forms.ProductForm;

import javax.validation.Valid;

@Controller
public class AdminController {

    private final AccountService accountService;
    private final ProductService productService;

    @Autowired
    public AdminController(AccountService accountService, ProductService productService) {
        this.accountService = accountService;
        this.productService = productService;
    }

    @GetMapping("/admin/users")
    public String userList(Model model) {
        model.addAttribute("allAccounts", accountService.getAll());
        return "users";
    }

    @GetMapping("/admin")
    public String getPageAdmin() {
        return "admin";
    }

    @RequestMapping(value = "/admin/products", method = RequestMethod.GET)
    public String getProducts (Model model) {
        model.addAttribute("products", productService.getAll());
        return "products";
    }

    @GetMapping(value = "/admin/products/add")
    public String addProduct () {
        return "productAdd";
    }

    @PostMapping(value = "/admin/products/add")
    public String addProductPost (@Valid ProductForm form, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("productForm",form);
            return "productAdd";
        }

        productService.addProduct(form);
        return "redirect:/admin/products";
    }

    @GetMapping(value = "/admin/products/delete/{id}")
    public String deleteProduct (@PathVariable Long id) {
        productService.deleteProductById(id);
        return "redirect:/admin/products";
    }
}
