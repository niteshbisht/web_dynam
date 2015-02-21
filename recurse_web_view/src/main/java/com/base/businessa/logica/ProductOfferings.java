package com.base.businessa.logica;

import java.util.List;

public class ProductOfferings {
	
	List<SimpleChildBundle> simpleChildBundle;
	
	List<ComplexChildBundles> complexChildBundle;

	public List<ComplexChildBundles> getComplexChildBundle() {
		return complexChildBundle;
	}

	public void setComplexChildBundle(List<ComplexChildBundles> complexChildBundle) {
		this.complexChildBundle = complexChildBundle;
	}

	public List<SimpleChildBundle> getSimpleChildBundle() {
		return simpleChildBundle;
	}

	public void setSimpleChildBundle(List<SimpleChildBundle> simpleChildBundle) {
		this.simpleChildBundle = simpleChildBundle;
	}
}
