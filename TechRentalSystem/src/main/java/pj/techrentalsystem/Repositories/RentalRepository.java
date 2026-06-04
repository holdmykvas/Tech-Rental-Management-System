package pj.techrentalsystem.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pj.techrentalsystem.Entities.Rental;
import pj.techrentalsystem.Enums.Status;

import java.time.LocalDate;
import java.util.List;

public interface RentalRepository extends JpaRepository<Rental,Long> {

    List<Rental> findByEndDateBeforeAndStatus(LocalDate date, Status status);
}
