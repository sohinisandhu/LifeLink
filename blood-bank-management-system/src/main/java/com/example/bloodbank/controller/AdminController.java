package com.example.bloodbank.controller;

import com.example.bloodbank.model.BloodInventory;
import com.example.bloodbank.service.BloodInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller; // <-- Check this import and annotation
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping; // <-- Check this import and annotation
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/admin") // <-- Does this line match exactly?
public class AdminController {

    @Autowired
    private BloodInventoryService bloodInventoryService;

    @GetMapping("/inventory") // <-- And does this line match exactly?
    public String viewInventory(Model model) {
        List<BloodInventory> inventory = bloodInventoryService.getFullInventory();
        model.addAttribute("inventory", inventory);
        return "admin/inventory";
    }

    @PostMapping("/inventory/update")
    public String updateStock(@RequestParam String bloodGroup, @RequestParam int units) {
        bloodInventoryService.updateStock(bloodGroup, units);
        return "redirect:/admin/inventory";
    }
}