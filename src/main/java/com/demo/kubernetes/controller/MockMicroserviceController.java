package com.demo.kubernetes.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.demo.kubernetes.model.MockMicroserviceResponse;
import com.demo.kubernetes.service.MockMicroserviceService;

import io.swagger.annotations.Api;

@Api(value="MockMicroserviceController", description="Kubernetes Demo2")
@RestController
public class MockMicroserviceController {
	
	@Autowired
	MockMicroserviceService service;
	
	@Autowired
	MockMicroserviceResponse response;
	
	
	private Logger logger = LoggerFactory.getLogger(MockMicroserviceController.class);
    
    @GetMapping("/mock/v1/getMockResponse/{functionName}")
    public MockMicroserviceResponse getResponse(@PathVariable String functionName) {
       logger.info("Inside MockMicroserviceController ...");
       response = service.getReponse();
       response.setFunctionName(functionName);
       return response;
    }

}
