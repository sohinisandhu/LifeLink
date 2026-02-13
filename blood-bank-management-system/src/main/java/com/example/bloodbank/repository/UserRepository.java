package com.example.bloodbank.repository;

import com.example.bloodbank.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // User findByUsername(String username);

    Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);
    
}
// public interface UserRepository extends JpaRepository<User, Long> {
//     boolean existsByUsername(String username);
// }
// In UserRepository.java
// public interface UserRepository extends JpaRepository<User, Long> {
//     Optional<User> findByUsername(String username);
//     Boolean existsByUsername(String username);
// }
