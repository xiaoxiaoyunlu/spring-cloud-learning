package com.test1.demo.web.rest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LoginController {
	
	private final Logger logger=Logger.getLogger(getClass());
	
	@Autowired
	private DiscoveryClient client;
	
	
	@RequestMapping(value="/test",method=RequestMethod.GET )
	public String Test(){
		ServiceInstance instance=client.getLocalServiceInstance();
		logger.info("/test,host:"+instance.getHost()+",service_id:"+instance.getServiceId());
		return "syserror";
	}

	
	@RequestMapping("/")
	public String index(){
		return "login";
	}
	
	@RequestMapping("/index")
	public String home(){
		return "index";
	}
	
}
