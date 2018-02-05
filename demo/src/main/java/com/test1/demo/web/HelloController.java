package com.test1.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test1.demo.exception.MyRestException;
import com.test1.demo.exception.MyWebException;


@RestController
public class HelloController {
	
	@Autowired
	private CounterService countService;

	
	@RequestMapping("/home")
	public String home() throws Exception {

		//pass
		
		countService.increment("didispace.home.count");
	        throw new Exception();

	}
	
	@RequestMapping("/rest")
	public String rest() throws Exception {

	    throw new MyRestException("101", "Sam 错误");

	}
}
