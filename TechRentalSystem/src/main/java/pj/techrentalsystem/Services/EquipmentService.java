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

    public Equipment getEquipmentById(Long id) {
        return equipmentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Equipment with this id { " + id + " } is not found!"));
    }

    public Equipment addEquipment(EquipmentDto equipmentDto) {
        Equipment equipment = new Equipment();
        equipment.setName(equipmentDto.getName());
        equipment.setDescription(equipmentDto.getDescription());
        equipment.setPrice(equipmentDto.getPrice());
        equipment.setStockQuantity(equipmentDto.getStockQuantity());
        equipment.setCategory(equipmentDto.getCategory());

        return equipmentRepository.save(equipment);
    }

    public EquipmentDto getEquipmentDtoById(Long id) {
        Equipment equipment = getEquipmentById(id);

        EquipmentDto dto = new EquipmentDto();
        dto.setName(equipment.getName());
        dto.setDescription(equipment.getDescription());
        dto.setPrice(equipment.getPrice());
        dto.setStockQuantity(equipment.getStockQuantity());
        dto.setCategory(equipment.getCategory());

        return dto;
    }

    public Equipment updateEquipment(Long id,EquipmentDto equipmentDto){
        Equipment equipment = equipmentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Equipment with id: " + id + " not found!"));

        equipment.setName(equipmentDto.getName());
        equipment.setDescription(equipmentDto.getDescription());
        equipment.setPrice(equipmentDto.getPrice());
        equipment.setStockQuantity(equipmentDto.getStockQuantity());
        equipment.setCategory(equipmentDto.getCategory());

        return equipmentRepository.save(equipment);
    }

    public void deleteEquipment(Long id) {
        if (!equipmentRepository.existsById(id)) {
            throw new IllegalArgumentException("Equipment with id: " + id + " not found!");
        }
        equipmentRepository.deleteById(id);
    }
}
