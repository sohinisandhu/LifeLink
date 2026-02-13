package com.example.bloodbank.controller;

import com.example.bloodbank.model.User;
import com.example.bloodbank.repository.UserRepository; // Use the repository here
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth") // Group all auth-related URLs together
public class AuthController {

    @Autowired
    private UserRepository userRepository; // It's better to use the repository directly for simple save/check operations

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Method to show the login page
    @GetMapping("/login")
    public String showLoginForm() {
        return "auth/login"; // Renders templates/auth/login.html
    }

    // Method to show the registration page
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "auth/register"; // Renders templates/auth/register.html
    }

    // Method to process the registration form
    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user, Model model) {
        // Check if username already exists
        if (userRepository.existsByUsername(user.getUsername())) {
            model.addAttribute("error", "Username already exists");
            return "auth/register"; // Go back to the form with an error message
        }

        // Encode the password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        
        // Here you would set default roles if needed
        
        userRepository.save(user);

        return "redirect:/auth/login?success"; // Redirect to login page with a success message
    }
}