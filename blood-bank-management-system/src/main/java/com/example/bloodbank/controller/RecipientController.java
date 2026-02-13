package com.example.bloodbank.controller;

import com.example.bloodbank.model.Recipient;
import com.example.bloodbank.service.RecipientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/recipients")
public class RecipientController {

    @Autowired
    private RecipientService recipientService;

    // Method to display the list of all recipient requests
    @GetMapping("/list")
    public String viewRecipientList(Model model) {
        List<Recipient> recipients = recipientService.getAllRecipients();
        model.addAttribute("recipients", recipients);
        // Renders the HTML file at: templates/recipient/recipient-list.html
        return "recipient/recipient-list";
    }

    // Method to show the form for creating a new blood request
    @GetMapping("/request")
    public String showRequestForm(Model model) {
        model.addAttribute("recipient", new Recipient());
        // Renders the HTML file at: templates/recipient/request-form.html
        return "recipient/request-form";
    }

    // Method to process the form and save the new recipient request
    @PostMapping("/save")
    public String saveRecipientRequest(@ModelAttribute("recipient") Recipient recipient) {
        recipientService.saveRecipient(recipient);
        // Redirect back to the list to see the new request
        return "redirect:/recipients/list";
    }

    // Method to handle the deletion of a recipient request (for an admin)
    @GetMapping("/delete/{id}")
    public String deleteRecipient(@PathVariable("id") Long id) {
        recipientService.deleteRecipient(id);
        return "redirect:/recipients/list";
    }
}