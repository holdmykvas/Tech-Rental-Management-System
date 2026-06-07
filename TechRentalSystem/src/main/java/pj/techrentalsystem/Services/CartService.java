package pj.techrentalsystem.Services;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;
import pj.techrentalsystem.DTOs.EquipmentDto;
import pj.techrentalsystem.Entities.Cart;
import pj.techrentalsystem.Entities.CartItem;
import pj.techrentalsystem.Entities.Equipment;
import pj.techrentalsystem.Repositories.EquipmentRepository;

@Service
@SessionScope
public class CartService {

    private final EquipmentRepository equipmentRepository;
    private final HelperService helperService;

    private final Cart cart = new Cart();

    public CartService(EquipmentRepository equipmentRepository, HelperService helperService) {
        this.equipmentRepository = equipmentRepository;
        this.helperService = helperService;
    }

    public Cart addItemToCart(Long id,int requestedQuantity) {
        Equipment equipment = equipmentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Equipment with this id { " + id + " } is not found!"));

        var currentQuantity = 0;
        if (cart.getItems().containsKey(id)) {
            currentQuantity = cart.getItems().get(id).getQuantity();
        }

        var totalQuantity = currentQuantity + requestedQuantity;

        if (!helperService.checkStockAvailability(equipment,requestedQuantity)) {
            throw new IllegalArgumentException("Not enough stock!");
        }

        EquipmentDto dto = new EquipmentDto();
        dto.setId(equipment.getId());
        dto.setName(equipment.getName());
        dto.setPrice(equipment.getPrice());
        dto.setCategory(equipment.getCategory());

        CartItem cartItem = new CartItem(dto, totalQuantity);
        cart.putItem(id,cartItem);

        return cart;
    }


    public Cart getSessionCart() {
        return cart;
    }
}
