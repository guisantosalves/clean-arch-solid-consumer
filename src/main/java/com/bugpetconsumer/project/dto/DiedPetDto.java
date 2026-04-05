package com.bugpetconsumer.project.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DiedPetDto implements Serializable {

    private Long id;
    private String petId;
    private String petName;
    private String lastDamageType;
    private BigDecimal lastDamageValue;
    private LocalDateTime diedAt;
}
