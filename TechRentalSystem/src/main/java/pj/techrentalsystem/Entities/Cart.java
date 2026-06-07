package pj.techrentalsystem.Entities;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cart {
                  //EquipmentID , Quantity
    private HashMap<Long,CartItem> items = new HashMap<>();

    public Map<Long, CartItem> getItems() {
        return items;
    }

    public void putItem(Long equipmentId, CartItem item) {
        this.items.put(equipmentId, item);
    }

    public void removeItem(Long equipmentId) {
        this.items.remove(equipmentId);
    }

    public void clearCart() {
        this.items.clear();
    }

    public boolean isEmpty() {
        return this.items.isEmpty();
    }


}
