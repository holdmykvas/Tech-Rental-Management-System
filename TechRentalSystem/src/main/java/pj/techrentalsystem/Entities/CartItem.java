package pj.techrentalsystem.Entities;

import pj.techrentalsystem.DTOs.EquipmentDto;

import java.math.BigDecimal;

public class CartItem {
    private EquipmentDto equipmentDto;
    private int quantity;

    public CartItem(EquipmentDto equipmentDto, int quantity) {
        this.equipmentDto = equipmentDto;
        this.quantity = quantity;
    }

    public BigDecimal getSubtotal(int days) {
        BigDecimal price = equipmentDto.getPrice();
        BigDecimal qty = BigDecimal.valueOf(quantity);
        BigDecimal duration = BigDecimal.valueOf(days);

        return price.multiply(qty).multiply(duration);
    }

    public EquipmentDto getEquipmentDto() {
        return equipmentDto;
    }

    public void setEquipmentDto(EquipmentDto equipmentDto) {
        this.equipmentDto = equipmentDto;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
