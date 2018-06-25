package com.camunda.demo.springboot.adapter;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import com.camunda.demo.springboot.ProcessConstants;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class FechaVenvimientoAdapter implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		log.info("Fecha de vencimiento... {}", execution.getVariable(ProcessConstants.VARIABLE_fechaVencimiento));
	}

}
