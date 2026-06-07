package pj.techrentalsystem.Services;

import org.springframework.stereotype.Service;
import pj.techrentalsystem.DTOs.EquipmentDto;
import pj.techrentalsystem.Entities.Equipment;
import pj.techrentalsystem.Repositories.EquipmentRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EquipmentService {

    private final EquipmentRepository equipmentRepository;

    public EquipmentService(EquipmentRepository equipmentRepository) {
        this.equipmentRepository = equipmentRepository;
    }

    public List<EquipmentDto> getAllEquipmentDto() {
        return equipmentRepository.findAll().stream().map(equipment -> {
            EquipmentDto dto = new EquipmentDto();
            dto.setId(equipment.getId());
            dto.setName(equipment.getName());
            dto.setDescription(equipment.getDescription());
            dto.setPrice(equipment.getPrice());
            dto.setStockQuantity(equipment.getStockQuantity());
            dto.setCategory(equipment.getCategory());
            return dto;
        }).collect(Collectors.toList());
    }

    public EquipmentDto getEquipmentDtoById(Long id) {
        Equipment equipment =  equipmentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Equipment with this id { " + id + " } is not found!"));

        EquipmentDto equipmentDto = new EquipmentDto();
        equipmentDto.setId(equipment.getId());
        equipmentDto.setName(equipment.getName());
        equipmentDto.setDescription(equipment.getDescription());
        equipmentDto.setPrice(equipment.getPrice());
        equipmentDto.setStockQuantity(equipment.getStockQuantity());
        equipmentDto.setCategory(equipment.getCategory());

        return equipmentDto;
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
