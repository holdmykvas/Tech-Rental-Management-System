package pj.techrentalsystem.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pj.techrentalsystem.Entities.RentalItem;

public interface RentalItemRepository extends JpaRepository<RentalItem, Long> {
}
