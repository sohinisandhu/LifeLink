package com.example.bloodbank.repository;

import com.example.bloodbank.model.Recipient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipientRepository extends JpaRepository<Recipient, Long> {
    // All CRUD methods are inherited from JpaRepository
}