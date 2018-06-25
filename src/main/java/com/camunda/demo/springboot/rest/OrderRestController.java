package com.camunda.demo.springboot.rest;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Date;
import java.util.List;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.task.Task;
import org.camunda.bpm.engine.variable.Variables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.camunda.demo.springboot.ProcessConstants;

@RestController
@RequestMapping("/order")
public class OrderRestController {
  
  @Autowired
  private ProcessEngine camunda;

  @RequestMapping(method=RequestMethod.POST)
  public void placeOrderPOST(String orderId, int amount) {
	  placeOrder(orderId, amount).getProcessDefinitionId();
  }
  
  @RequestMapping(method=RequestMethod.GET)
  public void multiInstanceUser() {
	  camunda.getRuntimeService().startProcessInstanceByKey("multiInstanceUser");
  }
  
  
  public void getTaskId() {
	  
	  List<Task> tasks = camunda.getTaskService().createTaskQuery().taskAssignee("kermit").list();
  }

  /**
   * we need a method returning the {@link ProcessInstance} to allow for easier tests,
   * that's why I separated the REST method (without return) from the actual implementaion (with return value)
   */
  public ProcessInstance placeOrder(String orderId, int amount) {
	  LocalDate localDate = LocalDate.now();
	  localDate.plusDays(2);
	  Instant instant = Instant.now();
	  instant.plus(2, ChronoUnit.MINUTES);
    return camunda.getRuntimeService().startProcessInstanceByKey(//
        ProcessConstants.PROCESS_KEY_order, //
        Variables //
          .putValue(ProcessConstants.VAR_NAME_orderId, orderId) //
          .putValue(ProcessConstants.VAR_NAME_amount, amount)//
          .putValue(ProcessConstants.VARIABLE_fechaVencimiento, instant.toString()));
  }
}
