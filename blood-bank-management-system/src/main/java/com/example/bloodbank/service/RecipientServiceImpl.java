package com.example.bloodbank.service;

import com.example.bloodbank.model.Recipient;
import com.example.bloodbank.repository.RecipientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipientServiceImpl implements RecipientService {

    @Autowired
    private RecipientRepository recipientRepository;

    @Override
    public List<Recipient> getAllRecipients() {
        return recipientRepository.findAll();
    }

    @Override
    public Optional<Recipient> getRecipientById(Long id) {
        return recipientRepository.findById(id);
    }

    @Override
    public Recipient saveRecipient(Recipient recipient) {
        // You can set a default status when a new request is created
        if (recipient.getStatus() == null) {
            recipient.setStatus("Pending");
        }
        return recipientRepository.save(recipient);
    }

    @Override
    public void deleteRecipient(Long id) {
        recipientRepository.deleteById(id);
    }
}