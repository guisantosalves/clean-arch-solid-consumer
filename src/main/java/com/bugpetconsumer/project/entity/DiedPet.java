package com.bugpetconsumer.project.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.bugpetconsumer.project.enums.DamageType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "died_pets")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DiedPet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "pet_id", nullable = false)
    private String petId;

    @Column(name = "pet_name", nullable = false)
    private String petName;

    @Enumerated(EnumType.STRING)
    @Column(name = "last_damage_type", nullable = false)
    private DamageType lastDamageType;

    @Column(name = "last_damage_value", precision = 19, scale = 2, nullable = false)
    private BigDecimal lastDamageValue;

    @Column(name = "died_at", nullable = false)
    private LocalDateTime diedAt;
}
