package com.spring.ehcache.onboot.app;

import org.springframework.cache.annotation.Cacheable;

public class Employee {

	@Cacheable(value = "employee")
	public InformationEmployee getInfo() {
		InformationEmployee em = new InformationEmployee("heman", 29, "areal",
				"visitor");
		System.out.println("creating bean");
		return em;
	}

}
