package com.camunda.demo.springboot.adapter;

import java.util.ArrayList;
import java.util.List;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import com.camunda.demo.springboot.ProcessConstants;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class InitCollection implements JavaDelegate {
	
	@Override
	public void execute(DelegateExecution execution) throws Exception {
		
		List<String> list = new ArrayList<>();
		list.add("demo");
		list.add("demo");
		list.add("demo");
		list.add("demo");
		list.add("demo");
		log.info("Crear un total de tareas humanas {}", list.size());
		execution.setVariable(ProcessConstants.VARIABLE_assigneeList, list);
	}

}
