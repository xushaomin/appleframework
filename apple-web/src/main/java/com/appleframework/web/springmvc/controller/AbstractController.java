package com.appleframework.web.springmvc.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.appleframework.web.bean.WrapperResponseEntity;

public abstract class AbstractController {
	
	protected static final ResponseEntity<WrapperResponseEntity> SUCCESS_MESSAGE = new ResponseEntity<WrapperResponseEntity>(
			new WrapperResponseEntity(true), HttpStatus.OK);

}