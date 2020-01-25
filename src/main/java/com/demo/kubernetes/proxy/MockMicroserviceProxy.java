package com.demo.kubernetes.proxy;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.demo.kubernetes.configuration.MockMicroserviceConfiguration;
import com.demo.kubernetes.model.MockMicroserviceResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class MockMicroserviceProxy {
	
	@Autowired
	MockMicroserviceResponse response;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	MockMicroserviceConfiguration config;
	
	
	public MockMicroserviceResponse callApigeeMockService()
	{
		try {
		HttpHeaders headers = new HttpHeaders();
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    HttpEntity <String> entity = new HttpEntity<String>(headers);
	    
		
		String responseString = restTemplate.exchange(config.getApigeeTargetUrl(), HttpMethod.GET, entity, String.class).getBody();
		response = new ObjectMapper().readValue(responseString, MockMicroserviceResponse.class);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return response;
	}

}
