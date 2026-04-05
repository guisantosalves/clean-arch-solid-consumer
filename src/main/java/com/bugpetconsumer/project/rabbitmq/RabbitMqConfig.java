package com.bugpetconsumer.project.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.support.converter.JacksonJsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

  @Value("${app.rabbitmq.queue.died-pet}")
  private String diedPetQueueName;

  @Bean
  public Queue diedPetQueue() {
    return new Queue(diedPetQueueName, true);
  }

  @Bean
  public MessageConverter jsonMessageConverter() {
    return new JacksonJsonMessageConverter();
  }

  // explaining rabbitListenerContainerFactory:
  // O container em si o Spring cria sozinho — mas ele precisa saber como configurar esses containers: qual conexão usar, qual converter aplicar, quantas threads, ack manual ou automático, etc.
  // Esse "molde de configuração" é o ContainerFactory. O Spring procura por um bean chamado rabbitListenerContainerFactory (nome exato, por convenção) e usa ele pra montar os containers de todos os
  // @RabbitListener da aplicação.
  @Bean
  public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(
      ConnectionFactory connectionFactory,
      MessageConverter jsonMessageConverter) {
    SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
    factory.setConnectionFactory(connectionFactory);
    factory.setMessageConverter(jsonMessageConverter);
    return factory;
  }
}
