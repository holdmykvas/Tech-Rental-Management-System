package pj.techrentalsystem.Entities;

import jakarta.persistence.*;
import pj.techrentalsystem.Enums.Category;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "equipment")
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;
    String description;
    BigDecimal price;
    int stockQuantity;
    @Enumerated(EnumType.STRING)
    Category category;

    @Version
    long version;

    @OneToMany (mappedBy = "equipment")
    List<RentalItem> rentalItemList;

    //GETTERS AND SETTERS


    public Long getId() {
        return id;
    }

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

    public List<RentalItem> getRentalItemList() {
        return rentalItemList;
    }

    public void setRentalItemList(List<RentalItem> rentalItemList) {
        this.rentalItemList = rentalItemList;
    }
}
