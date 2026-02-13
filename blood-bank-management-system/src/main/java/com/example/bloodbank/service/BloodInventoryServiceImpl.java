package com.example.bloodbank.service;

import com.example.bloodbank.model.BloodInventory;
import com.example.bloodbank.repository.BloodInventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BloodInventoryServiceImpl implements BloodInventoryService {

    @Autowired
    private BloodInventoryRepository inventoryRepository;

    @Override
    public List<BloodInventory> getFullInventory() {
        return inventoryRepository.findAll();
    }

    @Override
public BloodInventory updateStock(String bloodGroup, int units) {
    // 1. Add validation to prevent errors
    if (bloodGroup == null || bloodGroup.trim().isEmpty()) {
        throw new IllegalArgumentException("Blood Group cannot be empty.");
    }

    // 2. The rest of the logic is the same
    Optional<BloodInventory> existingStock = inventoryRepository.findByBloodGroup(bloodGroup.trim().toUpperCase());

    BloodInventory stockToUpdate;
    if (existingStock.isPresent()) {
        stockToUpdate = existingStock.get();
        int newUnits = stockToUpdate.getUnitsAvailable() + units;
        stockToUpdate.setUnitsAvailable(Math.max(0, newUnits)); // Prevents stock from going below zero
    } else {
        stockToUpdate = new BloodInventory(bloodGroup.trim().toUpperCase(), Math.max(0, units));
    }
    return inventoryRepository.save(stockToUpdate);
}
}