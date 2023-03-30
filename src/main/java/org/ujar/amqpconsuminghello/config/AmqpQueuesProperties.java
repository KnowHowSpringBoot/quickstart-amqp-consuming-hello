package org.ujar.amqpconsuminghello.config;

import jakarta.validation.constraints.NotNull;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "ujar.amqp.queues")
public record AmqpQueuesProperties(@NotNull String greeterExchange, @NotNull String greeterQueue) {

  public String getGreeterExchange() {
    return greeterExchange();
  }

  public String getGreeterQueue() {
    return greeterQueue();
  }
}
