package com.camunda.demo.springboot.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class UserDto implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	
}
