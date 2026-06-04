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

    private Long id;

    private LocalDate startDate;
    private LocalDate endDate;

    private BigDecimal totalPrice;

    private Status status;

    private List<RentalItemDto> rentalItemList;

    private Long userId;

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<RentalItemDto> getRentalItemList() {
        return rentalItemList;
    }

    public void setRentalItemList(List<RentalItemDto> rentalItemList) {
        this.rentalItemList = rentalItemList;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
