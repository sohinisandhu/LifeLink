// package com.example.bloodbank.repository;

// import com.example.bloodbank.model.Donor;
// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;

// @Repository
// public interface DonorRepository extends JpaRepository<Donor, Long> {
//     Donor findByEmail(String email);
// }
package com.example.bloodbank.repository;

import com.example.bloodbank.model.Donor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonorRepository extends JpaRepository<Donor, Long> {
    // Spring Data JPA will automatically create methods like:
    // - save(Donor donor)
    // - findById(Long id)
    // - findAll()
    // - deleteById(Long id)
    // ...and many more!
}