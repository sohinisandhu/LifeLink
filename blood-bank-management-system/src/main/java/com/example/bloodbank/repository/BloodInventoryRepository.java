package com.example.bloodbank.repository;

import com.example.bloodbank.model.BloodInventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BloodInventoryRepository extends JpaRepository<BloodInventory, Long> {
    // A custom method to find an inventory record by its blood group
    Optional<BloodInventory> findByBloodGroup(String bloodGroup);
}