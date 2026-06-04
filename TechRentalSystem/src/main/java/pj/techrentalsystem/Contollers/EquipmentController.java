package pj.techrentalsystem.Contollers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pj.techrentalsystem.DTOs.EquipmentDto;
import pj.techrentalsystem.Services.EquipmentService;


@Controller
@RequestMapping("equipment")
public class EquipmentController {

    private final EquipmentService equipmentService;

    public EquipmentController(EquipmentService equipmentService) {
        this.equipmentService = equipmentService;
    }

    //USER, ADMIN
    @GetMapping("/")
    public String getAllEquipment(Model model) {
        model.addAttribute("equipmentDto",equipmentService.getAllEquipment());
        return "equipment";
    }

    @GetMapping("/{id}")
    public String getEquipmentById(@PathVariable Long id, Model model){
        model.addAttribute("equipmentDto", equipmentService.getEquipmentById(id));
        return "equipment-details";
    }

    //ADMIN TODO

    @PostMapping("/admin")
    public String addEquipment(@RequestBody EquipmentDto equipmentDto , BindingResult bindingResult, Model model) {
        return "equipment-add";
    }

    @PutMapping("/admin/{id}")
    public String updateEquipment(@PathVariable Long id, @RequestBody EquipmentDto equipmentDto, BindingResult bindingResult, Model model) {
        return "equipment-update";
    }

    @DeleteMapping("/admin/{id}")
    public String deleteEquipment(@PathVariable Long id) {
        return "redirect/:";
    }
}
