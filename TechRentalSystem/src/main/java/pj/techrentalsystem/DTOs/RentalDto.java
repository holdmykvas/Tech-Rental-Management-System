package pj.techrentalsystem.DTOs;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import pj.techrentalsystem.Entities.RentalItem;
import pj.techrentalsystem.Entities.User;
import pj.techrentalsystem.Enums.Status;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class RentalDto {

    LocalDate startDate;
    LocalDate endDate;

    BigDecimal totalPrice;

    Status status;

    @OneToMany
    List<RentalItem> rentalItemList;

    @ManyToOne
    User user;
}
