package com.bugpetconsumer.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bugpetconsumer.project.entity.DiedPet;
import com.bugpetconsumer.project.service.DiedPetService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/died-pets")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class DiedPetController {

    private final DiedPetService service;

    @GetMapping
    public List<DiedPet> list() {
        return service.findAll();
    }
}
