package com.example.bloodbank.service;

import com.example.bloodbank.model.Donor;
import java.util.List;
import java.util.Optional;

public interface DonorService {
    List<Donor> getAllDonors();
    Optional<Donor> getDonorById(Long id);
    Donor saveDonor(Donor donor);
    Donor updateDonor(Long id, Donor donorDetails);
    void deleteDonor(Long id);
}