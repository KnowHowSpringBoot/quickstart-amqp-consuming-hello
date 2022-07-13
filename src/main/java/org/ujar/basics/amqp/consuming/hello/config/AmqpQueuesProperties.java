package org.ujar.basics.amqp.consuming.hello.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;

@Data
@Validated
@ConstructorBinding
@ConfigurationProperties(prefix = "ujar.amqp.queues")
public class AmqpQueuesProperties {

  @NonNull
  private final String greeterExchange;

  @NonNull
  private final String greeterQueue;
}
