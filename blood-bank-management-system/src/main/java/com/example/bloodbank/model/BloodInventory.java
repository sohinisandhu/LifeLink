package com.example.bloodbank.model;

import javax.persistence.*;

@Entity
@Table(name = "blood_inventory")
public class BloodInventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String bloodGroup; // e.g., "O+", "A-", "B+"

    @Column(nullable = false)
    private int unitsAvailable;

    // Constructors
    public BloodInventory() {
    }

    public BloodInventory(String bloodGroup, int unitsAvailable) {
        this.bloodGroup = bloodGroup;
        this.unitsAvailable = unitsAvailable;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public int getUnitsAvailable() {
        return unitsAvailable;
    }

    public void setUnitsAvailable(int unitsAvailable) {
        this.unitsAvailable = unitsAvailable;
    }
}