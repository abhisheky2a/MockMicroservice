package com.demo.kubernetes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.kubernetes.model.MockMicroserviceResponse;
import com.demo.kubernetes.proxy.MockMicroserviceProxy;


@Service
public class MockMicroserviceService {
	
	@Autowired
	MockMicroserviceProxy proxy;
	
	@Autowired
	MockMicroserviceResponse response;
	
	public MockMicroserviceResponse getReponse() {
		
		response = proxy.callApigeeMockService();
		return response;
		
	}

}
