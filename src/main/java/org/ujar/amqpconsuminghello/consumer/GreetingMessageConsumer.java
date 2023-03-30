package org.ujar.amqpconsuminghello.consumer;

import java.util.concurrent.CountDownLatch;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.ujar.amqpconsuminghello.model.Greeting;

@Component
@RequiredArgsConstructor
@Slf4j
@Getter
public class GreetingMessageConsumer {

  private CountDownLatch latch = new CountDownLatch(1);
  private String payload;

  public void consume(Greeting message) {
    log.info("( {} ) Received message, value: {}",
        Thread.currentThread().getName(), message);
    payload = message.toString();
    latch.countDown();
  }

  public void resetLatch() {
    latch = new CountDownLatch(1);
  }
}

