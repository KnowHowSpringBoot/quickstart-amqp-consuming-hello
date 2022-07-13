package org.ujar.basics.amqp.consuming.hello.service;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.ujar.basics.amqp.consuming.hello.model.Greeting;
import org.ujar.basics.amqp.consuming.hello.producer.GreetingMessageProducer;

@Service
@RequiredArgsConstructor
public class ServiceNotifier {

  private final GreetingMessageProducer messageProducer;

  @Scheduled(fixedDelay = 10000)
  public void scheduledCall() {
    messageProducer.send(new Greeting("Hello, World!"));
  }
}
