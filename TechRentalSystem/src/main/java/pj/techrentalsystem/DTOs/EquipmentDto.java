package pj.techrentalsystem.DTOs;

import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Min;
import pj.techrentalsystem.Entities.RentalItem;
import pj.techrentalsystem.Enums.Category;

import java.math.BigDecimal;
import java.util.List;

public class EquipmentDto {

    private Long id;

    private String name;
    private String description;
    @Min(0)
    private BigDecimal price;
    @Min(0)
    private int stockQuantity;
    private Category category;

    @OneToMany
    private List<RentalItemDto> rentalItemList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<RentalItemDto> getRentalItemList() {
        return rentalItemList;
    }

    public void setRentalItemList(List<RentalItemDto> rentalItemList) {
        this.rentalItemList = rentalItemList;
    }
}
