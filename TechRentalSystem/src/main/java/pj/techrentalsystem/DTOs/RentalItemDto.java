package pj.techrentalsystem.DTOs;

import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import pj.techrentalsystem.Entities.Equipment;
import pj.techrentalsystem.Entities.Rental;

import java.math.BigDecimal;

public class RentalItemDto {

    private Long id;

    @Min(0)
    private int quantity;
    @Min(0)
    private BigDecimal subTotalPrice;

    private Long rentalId;
    private Long equipmentId;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getSubTotalPrice() {
        return subTotalPrice;
    }

    public void setSubTotalPrice(BigDecimal subTotalPrice) {
        this.subTotalPrice = subTotalPrice;
    }

    public Long getRentalId() {
        return rentalId;
    }

    public void setRentalId(Long rentalId) {
        this.rentalId = rentalId;
    }

    public Long getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Long equipmentId) {
        this.equipmentId = equipmentId;
    }
}
