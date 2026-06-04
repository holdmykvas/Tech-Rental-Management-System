package pj.techrentalsystem.DTOs;

import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Min;
import pj.techrentalsystem.Entities.RentalItem;
import pj.techrentalsystem.Enums.Category;

import java.math.BigDecimal;
import java.util.List;

public class EquipmentDto {

    String name;
    String description;
    @Min(0)
    BigDecimal price;
    @Min(0)
    int stockQuantity;
    Category category;

    @OneToMany
    List<RentalItem> rentalItemList;
}
