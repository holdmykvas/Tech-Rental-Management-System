package pj.techrentalsystem.Entities;

import jakarta.persistence.*;
import pj.techrentalsystem.Enums.Status;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "rental")
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    LocalDate startDate;
    LocalDate endDate;

    BigDecimal totalPrice;

    Status status;

    @OneToMany(mappedBy = "rental", cascade = CascadeType.ALL, orphanRemoval = true)
    List<RentalItem> rentalItemList;

    @ManyToOne
    User user;

    //GETTERS AND SETTERS


    public Long getId() {
        return id;
    }

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

    public List<RentalItem> getRentalItemList() {
        return rentalItemList;
    }

    public void setRentalItemList(List<RentalItem> rentalItemList) {
        this.rentalItemList = rentalItemList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
