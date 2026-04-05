package com.bugpetconsumer.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bugpetconsumer.project.dto.DiedPetDto;
import com.bugpetconsumer.project.entity.DiedPet;
import com.bugpetconsumer.project.mapper.DiedPetMapper;
import com.bugpetconsumer.project.repository.DiedPetRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class DiedPetService {

    private final DiedPetRepository repository;
    private final DiedPetMapper mapper;

    @Transactional
    public DiedPet save(DiedPetDto dto) {
        DiedPet entity = mapper.toEntity(dto);
        return repository.save(entity);
    }

    @Transactional(readOnly = true)
    public List<DiedPet> findAll() {
        return repository.findAll();
    }
}
