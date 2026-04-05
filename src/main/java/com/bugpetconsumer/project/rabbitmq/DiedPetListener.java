package com.bugpetconsumer.project.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bugpetconsumer.project.dto.DiedPetDto;
import com.bugpetconsumer.project.entity.DiedPet;
import com.bugpetconsumer.project.service.DiedPetService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

// this one will listen to from the queue
@Slf4j
@Component
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class DiedPetListener {

    private final DiedPetService service;

    @RabbitListener(queues = "${app.rabbitmq.queue.died-pet}")
    public void onMessage(DiedPetDto dto) {
        log.info("Received died pet message: {}", dto);
        DiedPet saved = service.save(dto);
        log.info("Persisted died pet with id={} (petId={})", saved.getId(), saved.getPetId());
    }
}
