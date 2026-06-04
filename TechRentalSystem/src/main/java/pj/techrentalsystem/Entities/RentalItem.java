package pj.techrentalsystem.Entities;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class RentalItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    int quantity;
    BigDecimal subTotalPrice;

    @ManyToOne
    Rental rental;

    @ManyToOne
    Equipment equipment;

    //GETTERS AND SETTERS


    public Long getId() {
        return id;
    }

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

    public Rental getRental() {
        return rental;
    }

    public void setRental(Rental rental) {
        this.rental = rental;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }
}
