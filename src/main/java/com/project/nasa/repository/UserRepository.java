package com.project.nasa.repository;

import com.project.nasa.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);

//    @Query("select u from User u join u.roles r where r.name = 'ROLE_TECHNICIAN'")
//    Page<User> findPromotors(Pageable pageable);
//    @Query("select u from User u join u.roles r where r.name = 'ROLE_TECHNICIAN' and u.id = ?1")
//    User findClientById(Long id);
//    @Query("select u from User u join u.roles r where r.name = 'ROLE_USER'")
//    Page<User> findPainter(Pageable pageable);
//    @Query("select u from User u join u.roles r where r.name = 'ROLE_USER' and u.id = ?1")
//    User findPainterById(Long id);
}