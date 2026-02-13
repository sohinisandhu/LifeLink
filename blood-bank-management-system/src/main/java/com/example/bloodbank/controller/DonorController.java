package com.example.bloodbank.controller;

import com.example.bloodbank.model.Donor;
import com.example.bloodbank.service.DonorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/donors") // Using a plural noun is a common convention for controllers
public class DonorController {

    // 1. Inject the DonorService so the controller can use it.
    @Autowired
    private DonorService donorService;

    // 2. Method to display the list of all donors (Read)
    @GetMapping("/list")
    public String viewDonorList(Model model) {
        List<Donor> donors = donorService.getAllDonors();
        model.addAttribute("donors", donors);
        // This will look for an HTML file at: templates/donor/donor-list.html
        return "donor/donor-list";
    }

    // 3. Method to show the form for adding a new donor (Create - Step 1)
    @GetMapping("/add")
    public String showAddDonorForm(Model model) {
        // Create an empty donor object to bind to the form
        model.addAttribute("donor", new Donor());
        // This will look for an HTML file at: templates/donor/add-donor.html
        return "donor/add-donor";
    }

    // 4. Method to process the form and save the new donor (Create - Step 2)
    @PostMapping("/save")
    public String saveDonor(@ModelAttribute("donor") Donor donor) {
        donorService.saveDonor(donor);
        // Redirect back to the donor list to see the new entry
        return "redirect:/donors/list";
    }

    // 5. Method to show the form for editing an existing donor (Update - Step 1)
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        // Get the donor from the service or throw an error if not found
        Donor donor = donorService.getDonorById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid donor Id:" + id));
        model.addAttribute("donor", donor);
        // This will look for an HTML file at: templates/donor/edit-donor.html
        return "donor/edit-donor";
    }

    // 6. Method to process the form and update the donor (Update - Step 2)
    @PostMapping("/update/{id}")
    public String updateDonor(@PathVariable("id") Long id, @ModelAttribute("donor") Donor donor) {
        donorService.updateDonor(id, donor);
        return "redirect:/donors/list";
    }

    // 7. Method to handle the deletion of a donor (Delete)
    @GetMapping("/delete/{id}")
    public String deleteDonor(@PathVariable("id") Long id) {
        donorService.deleteDonor(id);
        return "redirect:/donors/list";
    }
}