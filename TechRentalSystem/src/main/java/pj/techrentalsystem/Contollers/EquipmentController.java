package pj.techrentalsystem.Contollers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pj.techrentalsystem.DTOs.EquipmentDto;
import pj.techrentalsystem.Services.EquipmentService;


@Controller
public class EquipmentController {

    private final EquipmentService equipmentService;

    public EquipmentController(EquipmentService equipmentService) {
        this.equipmentService = equipmentService;
    }

    //USER, ADMIN
    @GetMapping("/equipment")
    public String displayCatalog(Model model) {
        model.addAttribute("equipment",equipmentService.getAllEquipment());
        return "equipment";
    }

    @GetMapping("/equipment/{id}")
    public String getEquipmentById(@PathVariable Long id, Model model){
        model.addAttribute("equipmentDto", equipmentService.getEquipmentById(id));
        return "equipment-details";
    }

}
