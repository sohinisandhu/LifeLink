package com.example.bloodbank.model;

import javax.persistence.*;

@Entity
@Table(name = "recipients")
public class Recipient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String bloodType;
    private String hospitalName;
    private String contactNumber;
    private int requiredUnits;
    private String status; // e.g., "Pending", "Fulfilled"

    // This links the Recipient profile to the User account
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    // Constructors
    public Recipient() {
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public int getRequiredUnits() {
        return requiredUnits;
    }

    public void setRequiredUnits(int requiredUnits) {
        this.requiredUnits = requiredUnits;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}