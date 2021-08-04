package ru.itits.site.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.itits.site.models.Items;
import ru.itits.site.models.Product;
import ru.itits.site.service.ProductService;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class CartController {

    protected static List<Items> cart = new ArrayList<>();

    @Autowired
    private ProductService productService;

    @GetMapping("/addToCart/{id}")
    public String addToCart(@PathVariable Long id, HttpSession session) {
        Product product = productService.findById(id).orElse(null);

        if (session.getAttribute("cart") == null) {
            cart.add(new Items(product, 1));
            session.setAttribute("cart", cart);
        } else {
            cart = (List<Items>) session.getAttribute("cart");
        }

        int index = isExisting(id, session);

        if (index == -1) {
            cart.add(new Items(product, 1));
        }
        else {
            int quantity = cart.get(index).getQuantity();
            cart.get(index).setQuantity(quantity);
        }
        session.setAttribute("cart", cart);
//        return "cart";
        return "redirect:/shop";
    }

    private int isExisting(Long id, HttpSession session) {
        List<Items> cart = (List<Items>) session.getAttribute("cart");
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getProduct().getId() == id) {
                return i;
            }
        }
        return -1;
    }

    @GetMapping("/cart")
    public String getCart(Model model) {
        model.addAttribute("cartCount", cart.size());
        model.addAttribute("totalSum", getTotalSum(cart));
        model.addAttribute("cart", cart);
        return "cart";
    }

    @GetMapping("/cart/removeItem/{id}")
    public String removeItemCart(@PathVariable Long id, HttpSession session) {
        List<Items> cart = (List<Items>) session.getAttribute("cart");
        int index = isExisting(id, session);
        cart.remove(index);
        getTotalSum(cart);
        session.setAttribute("cart", cart);
        return "redirect:/cart";
    }

    public Integer getTotalSum(List<Items> cart) {
        Integer sum = 0;
        for (Items item: cart) {
            sum = sum + item.getProduct().getPrice();
        }
        return sum;
    }

    @GetMapping("/checkout")
    public String checkout(Model model) {
        model.addAttribute("totalSum", getTotalSum(cart));
        return "checkout";
    }
}
