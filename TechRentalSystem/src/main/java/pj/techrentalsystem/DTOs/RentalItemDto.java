package pj.techrentalsystem.DTOs;

import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import pj.techrentalsystem.Entities.Equipment;
import pj.techrentalsystem.Entities.Rental;

import java.math.BigDecimal;

public class RentalItemDto {

    @Min(0)
    int quantity;
    @Min(0)
    BigDecimal subTotalPrice;

    @ManyToOne
    Rental rental;

    @ManyToOne
    Equipment equipment;
}
