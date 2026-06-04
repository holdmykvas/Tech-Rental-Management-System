package pj.techrentalsystem.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pj.techrentalsystem.Entities.Equipment;

public interface EquipmentRepository extends JpaRepository<Equipment,Long> {
}
