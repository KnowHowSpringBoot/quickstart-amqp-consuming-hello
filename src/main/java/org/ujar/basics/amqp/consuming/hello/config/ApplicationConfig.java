package org.ujar.basics.amqp.consuming.hello.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
@EnableConfigurationProperties({AmqpQueuesProperties.class})
public class ApplicationConfig {
}
