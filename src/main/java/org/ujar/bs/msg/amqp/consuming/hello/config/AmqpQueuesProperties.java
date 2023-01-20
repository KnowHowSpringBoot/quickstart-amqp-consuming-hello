package org.ujar.bs.msg.amqp.consuming.hello.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;

@Validated
@ConstructorBinding
@ConfigurationProperties(prefix = "ujar.amqp.queues")
public record AmqpQueuesProperties(@NonNull String greeterExchange, @NonNull String greeterQueue) {

  public String getGreeterExchange() {
    return greeterExchange();
  }

  public String getGreeterQueue() {
    return greeterQueue();
  }
}
