// package com.example.bloodbank.controller;

// import com.example.bloodbank.model.BloodInventory;
// import com.example.bloodbank.service.BloodInventoryService;
// import com.example.bloodbank.service.DonorService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestParam;

// import java.util.List;

// @Controller
// public class AdminController {

//     @Autowired
//     private DonorService donorService;

//     @Autowired
//     private BloodInventoryService bloodInventoryService;

//     @GetMapping("/admin/dashboard")
//     public String adminDashboard(Model model) {
//         List<BloodInventory> bloodInventoryList = bloodInventoryService.findAll();
//         model.addAttribute("bloodInventory", bloodInventoryList);
//         return "admin/dashboard";
//     }

//     @GetMapping("/admin/donors")
//     public String viewDonors(Model model) {
//         model.addAttribute("donors", donorService.findAll());
//         return "admin/donors";
//     }

//     @PostMapping("/admin/add-blood")
//     public String addBlood(@RequestParam String bloodType, @RequestParam int quantity) {
//         bloodInventoryService.addBlood(bloodType, quantity);
//         return "redirect:/admin/dashboard";
//     }

//     @PostMapping("/admin/remove-blood")
//     public String removeBlood(@RequestParam Long id) {
//         bloodInventoryService.removeBlood(id);
//         return "redirect:/admin/dashboard";
//     }
// }

package com.example.bloodbank.controller;

import com.example.bloodbank.model.BloodInventory;
import com.example.bloodbank.repository.BloodInventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BloodInventoryController {

    @Autowired
    private BloodInventoryRepository bloodInventoryRepository;

    public List<BloodInventory> findAll() {
        return bloodInventoryRepository.findAll();
    }

    public void addBlood(String bloodType, int quantity) {
        BloodInventory inventory = new BloodInventory();
        inventory.setBloodGroup(bloodType);
        inventory.setUnitsAvailable(quantity);
        bloodInventoryRepository.save(inventory);
    }

    public void removeBlood(Long id) {
        bloodInventoryRepository.deleteById(id);
    }
}