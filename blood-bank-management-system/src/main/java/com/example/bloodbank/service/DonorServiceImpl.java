package com.example.bloodbank.service;

import com.example.bloodbank.model.Donor;
import com.example.bloodbank.repository.DonorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DonorServiceImpl implements DonorService {

    @Autowired
    private DonorRepository donorRepository;

    @Override
    public List<Donor> getAllDonors() {
        return donorRepository.findAll();
    }

    @Override
    public Optional<Donor> getDonorById(Long id) {
        return donorRepository.findById(id);
    }

    @Override
    public Donor saveDonor(Donor donor) {
        return donorRepository.save(donor);
    }

    @Override
    public Donor updateDonor(Long id, Donor donorDetails) {
        // Find the existing donor or throw an exception
        Donor existingDonor = donorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Donor not found with id: " + id));

        // Update the fields
        existingDonor.setName(donorDetails.getName());
        existingDonor.setBloodType(donorDetails.getBloodType());
        existingDonor.setContactNumber(donorDetails.getContactNumber());
        existingDonor.setAddress(donorDetails.getAddress());
        existingDonor.setLastDonationDate(donorDetails.getLastDonationDate());

        return donorRepository.save(existingDonor);
    }

    @Override
    public void deleteDonor(Long id) {
        donorRepository.deleteById(id);
    }
}