package com.camunda.demo.springboot.adapter;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class SubProcesoFailedAdapter implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		log.error("Debe fallar al proposito...");
		throw new UnsupportedOperationException("NO implementado");
	}

}
