package pj.techrentalsystem.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pj.techrentalsystem.Entities.Rental;

public interface RentalRepository extends JpaRepository<Rental,Long> {
}
