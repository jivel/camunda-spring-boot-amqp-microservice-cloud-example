package com.camunda.demo.springboot.conf;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.ComponentScan;

import com.camunda.demo.springboot.Application;

@ComponentScan(basePackageClasses={Application.class}) 
@EnableAutoConfiguration(exclude={RabbitAutoConfiguration.class})
@TestConfiguration
public class TestApplication {

//  @Mock  
//  private RabbitTemplate rabbitTemplate = mock(RabbitTemplate.class);
//  
//  @Bean
//  protected RabbitTemplate rabbitTemplate() {
//    return rabbitTemplate;
//  }
  
}
