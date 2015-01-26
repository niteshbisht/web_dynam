package com.nitesh.application.context.annotationbased;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AnnotationConfig {

	@Bean
	CommonBeanInterface myBeanExample() {
		return new MyBeanExampleImpl();
	}

	@Bean
	CommonBeanInterface myRealBean() {
		return new MyBeanExample();
	}
}
