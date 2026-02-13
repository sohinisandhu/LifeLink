package com.example.bloodbank.service;

import com.example.bloodbank.model.BloodInventory;
import java.util.List;

public interface BloodInventoryService {
    List<BloodInventory> getFullInventory();
    BloodInventory updateStock(String bloodGroup, int units);
}