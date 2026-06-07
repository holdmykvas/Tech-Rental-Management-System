package pj.techrentalsystem.Contollers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pj.techrentalsystem.Services.CartService;

@Controller
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/cart")
    public String viewCart(Model model) {
        model.addAttribute("cart", cartService.getSessionCart());
        return "cart";
    }

    @PostMapping("/cart/add")
    public String addToCart(@RequestParam Long equipmentId, @RequestParam int quantity) {
        cartService.addItemToCart(equipmentId,quantity);

        return "redirect:/equipment";
    }

    @PostMapping("/cart/remove")
    public String removeFromCart(@RequestParam Long equipmentId) {
        cartService.getSessionCart().removeItem(equipmentId);
        return "redirect:/cart";
    }
}
