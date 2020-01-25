package com.demo.kubernetes.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("mock-microservice")
public class MockMicroserviceConfiguration {
	
	String apigeeTargetUrl;

	public String getApigeeTargetUrl() {
		return apigeeTargetUrl;
	}

	public void setApigeeTargetUrl(String apigeeTargetUrl) {
		this.apigeeTargetUrl = apigeeTargetUrl;
	}

	
	
	
	

}
