package com.camunda.demo.springboot.adapter;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ShowUser implements JavaDelegate {
	
	@Override
	public void execute(DelegateExecution execution) throws Exception {
		log.info("Numero proporcionado {}", execution.getVariable("user"));
	}

}
