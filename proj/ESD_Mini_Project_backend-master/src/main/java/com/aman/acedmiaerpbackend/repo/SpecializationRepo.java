package com.aman.acedmiaerpbackend.repo;

import com.aman.acedmiaerpbackend.entity.Specialization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecializationRepo extends JpaRepository<Specialization, Integer> {
}