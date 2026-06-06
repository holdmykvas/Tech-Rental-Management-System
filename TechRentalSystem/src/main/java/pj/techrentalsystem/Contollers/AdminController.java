package pj.techrentalsystem.Contollers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pj.techrentalsystem.DTOs.EquipmentDto;
import pj.techrentalsystem.Services.EquipmentService;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final EquipmentService equipmentService;

    public AdminController(EquipmentService equipmentService) {
        this.equipmentService = equipmentService;
    }

    // Dashboard
    @GetMapping("/dashboard")
    public String showDashboard(Model model) {
        model.addAttribute("equipments", equipmentService.getAllEquipment());
        return "admin-dashboard";
    }

    // ADD
    @GetMapping("/equipment/add")
    public String showAddForm(Model model){
        model.addAttribute("equipmentDto", new EquipmentDto());
        return "admin-equipment";
    }

    @PostMapping("/equipment/add")
    public String processAddEquipment(@ModelAttribute("equipmentDto") EquipmentDto equipmentDto) {
        equipmentService.addEquipment(equipmentDto);
        return "redirect:/admin/dashboard?success";
    }

    //UPDATE
    @GetMapping("equipment/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model){
        EquipmentDto equipmentDto = equipmentService.getEquipmentDtoById(id);

        model.addAttribute("equipmentDto",equipmentDto);
        model.addAttribute("equipmentId", id);

        return "admin-equipment-update";
    }

    @PostMapping("/equipment/edit/{id}")
    public String processEditEquipment(@PathVariable Long id, @ModelAttribute("equipmentDto") EquipmentDto equipmentDto) {
        equipmentService.updateEquipment(id,equipmentDto);
        return "redirect:/admin/dashboard?updated";
    }

    //DELETE
    @DeleteMapping("/equipment/{id}")
    public String deleteEquipment(@PathVariable Long id) {
        equipmentService.deleteEquipment(id);
        return "redirect/:admin/dashboard?deleted";
    }
}
