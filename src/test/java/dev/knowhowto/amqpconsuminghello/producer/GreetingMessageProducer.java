package dev.knowhowto.amqpconsuminghello.producer;

import dev.knowhowto.amqpconsuminghello.config.AmqpQueuesProperties;
import dev.knowhowto.amqpconsuminghello.model.Greeting;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class GreetingMessageProducer {

  private final RabbitTemplate template;
  private final AmqpQueuesProperties topicDefinitions;

  public void send(Greeting message) {
    log.info("( {} ) Send message, value: {}", Thread.currentThread().getName(), message);
    template.convertAndSend(topicDefinitions.getGreeterExchange(), "greeting", message);
  }
}
