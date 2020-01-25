package com.demo.kubernetes;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2

public class MockMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MockMicroserviceApplication.class, args);
	}
	
    @Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.any())              
          .paths(PathSelectors.any())                          
          .build().apiInfo(apiInfo());                                          
    }
    
    private ApiInfo apiInfo() {
        return new ApiInfo(
          "MockMicroserviceApplication", 
          "Testing Kubernatis", 
          "MockMicroserviceApplication", 
          "Terms of service", 
          new Contact("Abhishek Chakraborty", "", "abhishek.y2a@gmail.com"), 
          "License of API", "API license URL", Collections.emptyList());
    }
    
    @Bean
    public RestTemplate getRestTemplate() {
       return new RestTemplate();
    }

}
