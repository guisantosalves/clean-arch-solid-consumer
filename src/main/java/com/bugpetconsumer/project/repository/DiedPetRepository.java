package com.bugpetconsumer.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bugpetconsumer.project.entity.DiedPet;

@Repository
public interface DiedPetRepository extends JpaRepository<DiedPet, Long> {
}
