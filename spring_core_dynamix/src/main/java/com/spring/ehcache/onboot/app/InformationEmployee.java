package com.spring.ehcache.onboot.app;

import java.io.Serializable;

public class InformationEmployee implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8537243897751020011L;
	String name;
	int age;
	String organization;
	String address;

	/**
	 * @param name
	 * @param age
	 * @param organization
	 * @param address
	 */
	public InformationEmployee(String name, int age, String organization,
			String address) {
		super();
		this.name = name;
		this.age = age;
		this.organization = organization;
		this.address = address;
	}

}
