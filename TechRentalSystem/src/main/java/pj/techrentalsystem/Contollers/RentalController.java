package pj.techrentalsystem.Contollers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pj.techrentalsystem.Entities.Cart;
import pj.techrentalsystem.Entities.CartItem;
import pj.techrentalsystem.Entities.User;
import pj.techrentalsystem.Repositories.UserRepository;
import pj.techrentalsystem.Services.CartService;
import pj.techrentalsystem.Services.RentalService;

import java.security.Principal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/rentals")
public class RentalController {

    private final RentalService rentalService;
    private final CartService cartService;
    private final UserRepository userRepository;

    public RentalController(RentalService rentalService, CartService cartService, UserRepository userRepository) {
        this.rentalService = rentalService;
        this.cartService = cartService;
        this.userRepository = userRepository;
    }

    @PostMapping("/checkout")
    public String processCheckout(@RequestParam LocalDate startDate, @RequestParam LocalDate endDate, Principal principal) {
        Cart cart = cartService.getSessionCart();

        if (cart.isEmpty()) {
            throw new IllegalArgumentException("You can't checkout with empty cart.");
        }

        User user = userRepository.findByEmail(principal.getName()).orElseThrow(() -> new IllegalArgumentException("User session not found"));

        Map<Long,Integer> checkoutItems = new HashMap<>();
        for (Map.Entry<Long, CartItem> entry : cart.getItems().entrySet()) {
            checkoutItems.put(entry.getKey(),entry.getValue().getQuantity());
        }

        rentalService.processCheckout(user.getId(),startDate,endDate,checkoutItems);
        cart.clearCart();
        return "redirect:/rentals/my-rentals";
    }

    @GetMapping("/my-rentals")
    public String viewRentals(Model model,Principal principal) {
        User user = userRepository.findByEmail(principal.getName())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        model.addAttribute("rentals", rentalService.getRentalById(user.getId()));
        return "my-rentals";
    }
}
