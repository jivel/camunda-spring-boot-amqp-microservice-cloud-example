package com.camunda.demo.springboot.adapter;

import java.util.ArrayList;
import java.util.List;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.camunda.demo.springboot.ProcessConstants;
import com.camunda.demo.springboot.model.UserDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@ConfigurationProperties
public class RetrievePaymentAdapter implements JavaDelegate {

	@Autowired
	private RestTemplate rest;

	private String restProxyHost;
	private String restProxyPort;

	private String restEndpoint() {
		return "http://" + restProxyHost + ":" + restProxyPort + "/payment/charges";
	}

	public static class CreateChargeRequest {
		public int amount;
	}

	public static class CreateChargeResponse {
		public String transactionId;
	}

	@Override
	public void execute(DelegateExecution ctx) throws Exception {
		CreateChargeRequest request = new CreateChargeRequest();
		request.amount = (int) ctx.getVariable(ProcessConstants.VAR_NAME_amount);

		CreateChargeResponse response = rest.postForObject( //
				restEndpoint(), //
				request, //
				CreateChargeResponse.class);

		List<UserDto> list = new ArrayList<>();
		UserDto userDto;
		for (int i = 0; i < request.amount; i++) {
			userDto = new UserDto();
			userDto.setId(i);
			userDto.setName("demo" + i);
			list.add(userDto);
		}
		ctx.setVariable(ProcessConstants.VARIABLE_paymentTransactionId, response.transactionId);

		log.info("Crear un total de tareas humanas {}", list.size());
		ctx.setVariable("users", list);

	}

	public String getRestProxyHost() {
		return restProxyHost;
	}

	public void setRestProxyHost(String restProxyHost) {
		this.restProxyHost = restProxyHost;
	}

	public String getRestProxyPort() {
		return restProxyPort;
	}

	public void setRestProxyPort(String restProxyPort) {
		this.restProxyPort = restProxyPort;
	}

}
