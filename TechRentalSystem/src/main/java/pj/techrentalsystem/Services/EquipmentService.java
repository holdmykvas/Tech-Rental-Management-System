package pj.techrentalsystem.Services;

import org.springframework.stereotype.Service;
import pj.techrentalsystem.DTOs.EquipmentDto;
import pj.techrentalsystem.Entities.Equipment;
import pj.techrentalsystem.Repositories.EquipmentRepository;

import java.util.List;

@Service
public class EquipmentService {

    private final EquipmentRepository equipmentRepository;

    public EquipmentService(EquipmentRepository equipmentRepository) {
        this.equipmentRepository = equipmentRepository;
    }

    public List<Equipment> getAllEquipment() {
        return equipmentRepository.findAll();
    }

    public Equipment addEquipment(EquipmentDto equipmentDto) {
        Equipment equipment = new Equipment();
        //TODO finish the validation
        return equipmentRepository.save(equipment);
    }

    public Equipment getEquipmentById(Long id) {
        return equipmentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Equipment with this id { " + id + " } is not found!"));
    }
}
