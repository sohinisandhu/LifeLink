package com.example.bloodbank.service;

import com.example.bloodbank.model.Recipient;
import java.util.List;
import java.util.Optional;

public interface RecipientService {
    List<Recipient> getAllRecipients();
    Optional<Recipient> getRecipientById(Long id);
    Recipient saveRecipient(Recipient recipient);
    void deleteRecipient(Long id);
}