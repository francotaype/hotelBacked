package com.francode.hotelBacked.persistence.repository;

import com.francode.hotelBacked.domain.entity.ERole;
import com.francode.hotelBacked.domain.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaRolRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
