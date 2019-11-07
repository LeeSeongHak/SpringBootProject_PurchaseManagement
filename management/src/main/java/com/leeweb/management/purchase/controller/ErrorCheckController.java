package com.leeweb.management.purchase.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorCheckController {

	@RequestMapping(value = "/ErrorTest", method = RequestMethod.GET)
	public String numberFormatExceptionTest() {
		Integer.parseInt("test");
		return "ErrorTest";
	}

}
