package com.camunda.demo.springboot.conf.plugin;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;

import lombok.extern.slf4j.Slf4j;

/**
 * In this listener you can do basically everything. You could also implement it as 
 * Spring bean an e.g. send events via Kafka to a central monitor - or to call the ELK stack
 * to hand over some events.
 */
@Slf4j
public class SendEventListener implements ExecutionListener {

	@Override
	public void notify(DelegateExecution execution) throws Exception {
		log.info("Hello world. There was an event '{}'! It came from activity '{}' for process instance '{}'",
				execution.getEventName(),
				execution.getCurrentActivityId(),
				execution.getProcessInstanceId());
	}

}
